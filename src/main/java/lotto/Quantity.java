package lotto;

import java.util.Objects;

public class Quantity {
    private final int quantity;

    private Quantity(int quantity) {
        this.quantity = quantity;
    }

    public static Quantity from(int quantity) {
        return new Quantity(quantity);
    }

    public static Quantity from(String quantity) {
        Validate.isNumber(quantity);
        return Quantity.from(Integer.parseInt(quantity));
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Quantity that = (Quantity) o;
        return quantity == that.quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantity);
    }
}
