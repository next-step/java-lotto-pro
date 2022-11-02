package step3.domain.lotto;

import static step3.type.ErrorMessageType.INPUT_NOT_ALLOW_NEGATIVE_NUMBER;

public class ManualLottoQuantity {

    private final int quantity;

    public ManualLottoQuantity(int quantity) {
        validateNegative(quantity);
        this.quantity = quantity;
    }

    private void validateNegative(int amount) {
        if (isNegative(amount)) {
            throw new IllegalArgumentException(INPUT_NOT_ALLOW_NEGATIVE_NUMBER.getMessage());
        }
    }

    private boolean isNegative(int number) {
        return number < 0;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "ManualLottoQuantity{" +
                "quantity=" + quantity +
                '}';
    }
}
