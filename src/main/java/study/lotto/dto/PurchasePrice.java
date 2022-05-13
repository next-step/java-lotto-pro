package study.lotto.dto;

import java.math.BigDecimal;
import java.util.Objects;

public class PurchasePrice {
    private static final String NOTNULL_ERROR = "구입금액을 입력해 주세요.";

    private final BigDecimal price;

    public PurchasePrice(String price) {
        this.price = validate(price);
    }

    public BigDecimal getPrice() {
        return price;
    }

    private BigDecimal validate(String price) {
        validateNonNull(price);
        validateNonEmpty(price);
        return validateNumber(price);
    }

    private BigDecimal validateNumber(String price) {
        try {
            return BigDecimal.valueOf(Long.parseLong(price));
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
