package validation;

public class InputValidator {

    private InputValidator() {

    }

    public static int lottoPrice(int lottoPrice) {
        validateAmountByThousand(lottoPrice);
        return lottoPrice;
    }

    private static void validateAmountByThousand(int lottoPrice) {
        if (lottoPrice % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금앱은 1000원 단위로 입력 가능합니다.");
        }
    }
}
