package lotto.domain;

import java.util.Objects;
import lotto.view.OutputView;

public class LottoPurchaseQuantity {
    public static final String PRINT_QUANTITY_FORMAT = "%d개를 구매했습니다.";

    private final int quantity;

    private LottoPurchaseQuantity(int quantity) {
        this.quantity = quantity;
    }

    public static LottoPurchaseQuantity of(int quantity) {
        return new LottoPurchaseQuantity(quantity);
    }

    public static LottoPurchaseQuantity manualQuantity(String inputQuantity) {
        try {
            return new LottoPurchaseQuantity(Integer.parseInt(inputQuantity));
        } catch (NumberFormatException e) {
            throw new NumberFormatException(OutputView.ERROR_MESSAGE_INPUT_ONLY_NUMBER);
        }
    }

    public LottoPurchaseQuantity calculateAutoQuantity(int purchaseQuantity) {
        int autoQuantity = purchaseQuantity - this.quantity;
        if (autoQuantity < 0) {
            throw new IllegalArgumentException(String.format(OutputView.ERROR_MESSAGE_FORMAT_MANUAL_LOTTO_EXCEED_QUANTITY, purchaseQuantity));
        }
        return new LottoPurchaseQuantity(autoQuantity);
    }

    public String getMessage() {
        return String.format(PRINT_QUANTITY_FORMAT, this.quantity);
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
        LottoPurchaseQuantity that = (LottoPurchaseQuantity) o;
        return quantity == that.quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantity);
    }
}
