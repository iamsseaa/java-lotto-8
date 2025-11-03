package view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import validation.InputValidator;

public class InputView {

    private static final String DELIMITER = ",";

    public int readLottoPrice() {
        while (true) {
        try {
            System.out.println("구입 금액을 입력해 주세요.");
            String input = Console.readLine();

            int price = InputValidator.lottoPrice(input);

            return price;

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        }
    }

    public List<Integer> readWinningNumbers() {
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                String input = Console.readLine();
                List<Integer> numbers = Arrays.stream(input.split(DELIMITER))
                        .map(s -> Integer.parseInt(s.trim()))
                        .collect(Collectors.toList());

                return numbers;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int readBonusNumber() {
        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                int input = Integer.parseInt(Console.readLine());

                return input;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
