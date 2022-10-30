package step3.domain.amount;

import java.util.Objects;

import static step3.type.ErrorMessageType.INPUT_NOT_ALLOW_NEGATIVE_NUMBER;

public class Amount {

    private final int amount;

    public Amount(int amount) {
        validateNegative(amount);
        this.amount = amount;
    }

    public int getLottoPurchasesCount(int lottoPrice) {
        return amount / lottoPrice;
    }

    private void validateNegative(int amount) {
        if (isNegative(amount)) {
            throw new IllegalArgumentException(INPUT_NOT_ALLOW_NEGATIVE_NUMBER.getMessage());
        }
    }

    private boolean isNegative(int number) {
        return number < 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Amount amount1 = (Amount) o;
        return amount == amount1.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }

    @Override
    public String toString() {
        return "Amount{" +
                "amount=" + amount +
                '}';
    }
}
