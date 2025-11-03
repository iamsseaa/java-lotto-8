package view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {
    public int readLottoPrice() {
        System.out.println("구입 금액을 입력해 주세요.");
        int input = Integer.parseInt(Console.readLine());

        return input;
    }

    public void readWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
    }

    public int readBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        int input = Integer.parseInt(Console.readLine());

        return input;
    }
}
