package view;

import java.util.List;
import java.util.Map;
import lotto.Lotto;
import lotto.Rank;

public class OutputView {
    public void printUserLottos(int count, List<Lotto> lottos) {
        System.out.println(count + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            lotto.printNumbers();
        }
    }

    public void printStatistics(Map<Rank, Integer> statistics) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        // Rank Enum에 미리 상금 정보를 넣어두면 더 깔끔하게 출력할 수 있습니다.
        System.out.println("3개 일치 (5,000원) - " + statistics.get(Rank.FIFTH) + "개");
        System.out.println("4개 일치 (50,000원) - " + statistics.get(Rank.FOURTH) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + statistics.get(Rank.THIRD) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + statistics.get(Rank.SECOND) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + statistics.get(Rank.FIRST) + "개");
    }

    public void printProfitRate(double profitRate) {
        System.out.println("총 수익률은 " + profitRate + "%입니다.");
    }
}
