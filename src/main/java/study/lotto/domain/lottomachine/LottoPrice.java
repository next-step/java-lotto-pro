package study.lotto.domain.lottomachine;

import java.math.BigDecimal;
import java.util.Objects;

public class LottoPrice {
    private static final BigDecimal DEFAULT_LOTTO_PRICE = BigDecimal.valueOf(1000);

    private final BigDecimal value;

    public LottoPrice() {
        this(DEFAULT_LOTTO_PRICE);
    }

    public LottoPrice(BigDecimal value) {
        this.value = value;
    }

    public int maximumIssuableCount(BigDecimal money) {
        if (isGreaterThan(money)) {
            return 0;
        }
        return money.divideAndRemainder(value)[0].intValue();
    }

    public BigDecimal totalPrice(int numberOfLotto) {
        return value.multiply(new BigDecimal(numberOfLotto));
    }

    private boolean isGreaterThan(BigDecimal money) {
        return value.compareTo(money) > 0;
    }

    @Override
    public String toString() {
        return "LottoPrice{" +
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
        LottoPrice that = (LottoPrice) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
