package lotto.model;

public class PassiveQuantity {
    private static final String REGEX = "[0-9]+";
    private static final String NUMBER_ERROR_MESSAGE = "숫자만 입력해주세요.";

    private final int quantity;

    public PassiveQuantity(String quantity) {
        validateNumber(quantity);
        this.quantity = Integer.parseInt(quantity);
    }

    public int getQuantity() {
        return quantity;
    }

    private void validateNumber(String quantity) {
        if (!quantity.matches(REGEX)) {
            throw new IllegalArgumentException(NUMBER_ERROR_MESSAGE);
        }
    }
}
