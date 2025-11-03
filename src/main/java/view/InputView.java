package view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import validation.InputValidator;

public class InputView {

    private static final String DELIMITER = ",";

    public int readLottoPrice() {
        System.out.println("구입 금액을 입력해 주세요.");
        int input = Integer.parseInt(Console.readLine());

        return InputValidator.lottoPrice(input);
    }

    public List<Integer> readWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        List<Integer> numbers = Arrays.stream(input.split(DELIMITER))
                .map(s -> Integer.parseInt(s.trim())) // 공백 제거 후 숫자로 변환
                .collect(Collectors.toList());

        return numbers;
    }

    public int readBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        int input = Integer.parseInt(Console.readLine());

        return input;
    }
}
