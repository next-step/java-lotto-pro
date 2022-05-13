package study.lotto.dto;

import java.util.Objects;

public class PurchasePrice {
    private static final String NOTNULL_ERROR = "구입금액을 입력해 주세요.";

    private final int price;

    public PurchasePrice(String price) {
        this.price = validate(price);
    }

    public int get() {
        return price;
    }

    private int validate(String price) {
        validateNonNull(price);
        validateNonEmpty(price);
        return validateNumber(price);
    }

    private int validateNumber(String price) {
        try {
            return Integer.parseInt(price);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("금액은 숫자여야 합니다.");
        }
    }

    private void validateNonNull(String price) {
        if (Objects.isNull(price)) {
            throw new IllegalArgumentException(NOTNULL_ERROR);
        }
    }

    private void validateNonEmpty(String price) {
        if (price.isEmpty()) {
            throw new IllegalArgumentException(NOTNULL_ERROR);
        }
    }
}
