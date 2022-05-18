package study.lotto.dto;

import java.math.BigDecimal;

public class PurchasePrice {
    private final BigDecimal value;

    public PurchasePrice(String value) {
        this.value = validate(value);
    }

    public BigDecimal get() {
        return value;
    }

    private BigDecimal validate(String price) {
        return parseNumber(price);
    }

    private BigDecimal parseNumber(String priceString) {
        return BigDecimal.valueOf(Long.parseLong(priceString));
    }
}
