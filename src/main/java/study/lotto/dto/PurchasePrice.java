package study.lotto.dto;

import java.math.BigDecimal;
import java.util.Objects;

public class PurchasePrice {
    private static final String NOTNULL_ERROR = "구입금액을 입력해 주세요.";

    private final BigDecimal value;

    public PurchasePrice(String value) {
        this.value = validate(value);
    }

    public BigDecimal get() {
        return value;
    }

    private BigDecimal validate(String price) {
        validateNonNull(price);
        validateNonEmpty(price);
        return validateNumber(price);
    }

    private BigDecimal validateNumber(String priceString) {
        try {
            return parseNumber(priceString);
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

    private BigDecimal parseNumber(String priceString) {
        BigDecimal parsedPrice = BigDecimal.valueOf(Long.parseLong(priceString));
        if (BigDecimal.ZERO.compareTo(parsedPrice) >= 0) {
            throw new IllegalArgumentException("구입 금액은 0보다 커야 합니다.");
        }
        return parsedPrice;
    }
}
