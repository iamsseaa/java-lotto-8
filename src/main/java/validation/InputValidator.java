package validation;

import java.util.InputMismatchException;

public class InputValidator {

    private InputValidator() {

    }

    public static int lottoPrice(String lottoPrice) {
        int price = Integer.parseInt(lottoPrice);

        validateNumeric(lottoPrice);
        validateAmountByThousand(price);
        validateMinimumPrice(price);
        return price;
    }

    private static void validateAmountByThousand(int lottoPrice) {
        if (lottoPrice % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금앱은 1000원 단위로 입력 가능합니다.");
        }
    }

    private static void validateMinimumPrice(int lottoPrice) {
        if (lottoPrice < 1000) {
            throw new IllegalArgumentException("[Error] 로또 구입 금액은 1000원 이상부터 가능합니다.");
        }
    }

    private static void validateNumeric(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 입력값이 비어있습니다.");
        }

        try {
            Integer.parseInt(input.trim());
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("[ERROR] 입력은 숫자만 가능합니다.");
        }
    }
}
