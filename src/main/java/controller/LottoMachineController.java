package controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.Lotto;
import lotto.Rank;
import view.InputView;
import view.OutputView;

public class LottoMachineController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoMachineController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        startLottoMachine();
    }

    public void startLottoMachine() {
        int lottoPrice = inputView.readLottoPrice();
        int count = lottoPrice / 1000;
        List<Lotto> lottos = createLottos(count);
        outputView.printUserLottos(count, lottos);

        Lotto winningLotto = new Lotto(inputView.readWinningNumbers());
        int bonusNumber = inputView.readBonusNumber();

        Map<Rank, Integer> statistics = calculateStatistics(lottos, winningLotto, bonusNumber);
        long totalWinnings = calculateTotalWinnings(statistics);
        double profitRate = ((double) totalWinnings / (double) lottoPrice) * 100.0;

        outputView.printStatistics(statistics);
        outputView.printProfitRate(profitRate);
    }

    public List<Lotto> createLottos(int count) {
        return Stream.generate(() -> new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6))).limit(count).collect(Collectors.toList());
    }

    private Map<Rank, Integer> calculateStatistics(List<Lotto> lottos, Lotto winningLotto, int bonusNumber) {
        Map<Rank, Integer> statistics = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            statistics.put(rank, 0);
        }

        for (Lotto lotto : lottos) {
            long matchCount = lotto.countMatches(winningLotto);
            boolean hasBonus = lotto.contains(bonusNumber);

            Rank rank = Rank.valueOf(matchCount, hasBonus);
            statistics.put(rank, statistics.get(rank) + 1);
        }
        return statistics;
    }

    private long calculateTotalWinnings(Map<Rank, Integer> statistics) {
        // Java Stream을 사용한 계산
        return statistics.entrySet().stream()
                .mapToLong(entry -> {
                    Rank rank = entry.getKey();
                    int count = entry.getValue();
                    return rank.getPrizeMoney() * count;
                })
                .sum();
    }

}
