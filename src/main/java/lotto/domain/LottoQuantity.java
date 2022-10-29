package lotto.domain;

import java.util.Objects;
import lotto.view.OutputView;

public class LottoQuantity {
    private final int quantity;

    private LottoQuantity(int quantity) {
        this.quantity = quantity;
    }

    public static LottoQuantity of(int quantity) {
        return new LottoQuantity(quantity);
    }

    public String getMessage() {
        return String.format(OutputView.PRINT_QUANTITY_FORMAT, this.quantity);
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
        LottoQuantity that = (LottoQuantity) o;
        return quantity == that.quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantity);
    }
}
