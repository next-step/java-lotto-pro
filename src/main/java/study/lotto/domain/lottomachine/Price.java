package study.lotto.domain.lottomachine;

import java.math.BigDecimal;
import java.util.Objects;

public class Price {
    private final BigDecimal value;

    public Price(String value) {
        this.value = validate(value);
    }

    public Price(BigDecimal value) {
        this.value = value;
    }

    public int divide(Price price) {
        if (isLessThan(price)) {
            return 0;
        }
        return value.divideAndRemainder(price.value)[0].intValue();
    }

    public BigDecimal multiply(int count) {
        return value.multiply(new BigDecimal(count));
    }

    private boolean isLessThan(Price price) {
        return value.compareTo(price.value) < 0;
    }

    private BigDecimal validate(String price) {
        BigDecimal parsedValue = parseNumber(price);
        if (parsedValue.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("구입금액은 0보다 커야합니다.");
        }
        return parsedValue;
    }

    private BigDecimal parseNumber(String priceString) {
        return BigDecimal.valueOf(Long.parseLong(priceString));
    }

    @Override
    public String toString() {
        return "Price{" +
                "value=" + value +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Price price = (Price) o;
        return Objects.equals(value, price.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
