package controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.Lotto;
import view.InputView;

public class LottoMachineController {
    private final InputView inputView;

    public LottoMachineController() {
        this.inputView = new InputView();
    }

    public void run() {
        startLottoMachine();
    }

    public void startLottoMachine() {
        int lottoPrice = inputView.readLottoPrice();
        List<Lotto> lottos = createLottos(lottoPrice);

        inputView.readWinningNumbers();
        int bonusNumber = inputView.readBonusNumber();
    }

    public List<Lotto> createLottos(int lottoPrice) {
        int count = lottoPrice / 1000;
        return Stream.generate(() -> new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6))).limit(count).collect(Collectors.toList());
    }
}
