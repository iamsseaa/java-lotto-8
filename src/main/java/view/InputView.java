package view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public int readLottoPrice() {
        System.out.println("구입 금액을 입력해 주세요.");
        int input = Integer.parseInt(Console.readLine());

        return input;
    }

}
