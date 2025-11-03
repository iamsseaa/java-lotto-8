package view;

import java.util.List;
import lotto.Lotto;

public class OutputView {
    public void printUserLottos(int count, List<Lotto> lottos) {
        System.out.println(count + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            lotto.printNumbers();
        }
    }
}
