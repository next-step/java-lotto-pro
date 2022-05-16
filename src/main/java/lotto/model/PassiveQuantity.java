package lotto.model;

public class PassiveQuantity {
    private static final String REGEX = "[0-9]+";
    private static final String NUMBER_ERROR_MESSAGE = "숫자만 입력해주세요.";

    public PassiveQuantity(String quantity) {
        validateNumber(quantity);
    }

    private static void validateNumber(String price) {
        if (!price.matches(REGEX)) {
            throw new IllegalArgumentException(NUMBER_ERROR_MESSAGE);
        }
    }
}
