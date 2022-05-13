package study.lotto.automatic.domain;

import java.math.BigDecimal;
import java.util.Objects;

public class LottoPrice {
    private static final BigDecimal DEFAULT_LOTTO_PRICE = BigDecimal.valueOf(1000);

    private final BigDecimal price;

    public LottoPrice() {
        this(DEFAULT_LOTTO_PRICE);
    }

    public LottoPrice(BigDecimal price) {
        this.price = price;
    }

    public int maximumIssuableCount(BigDecimal money) {
        if (isGreaterThan(money)) {
            return 0;
        }
        return money.divideAndRemainder(price)[0].intValue();
    }

    private boolean isGreaterThan(BigDecimal money) {
        return price.compareTo(money) > 0;
    }

    @Override
    public String toString() {
        return "LottoPrice{" +
                "price=" + price +
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
        LottoPrice that = (LottoPrice) o;
        return Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price);
    }
}
