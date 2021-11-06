package lotto.model;

import java.util.Objects;

public class Payment {
    static final int LOTTO_PRICE = 1000;
    private static final String MIN_MONEY_ERR_MSG = "구입 금액은 " + LOTTO_PRICE + "원 이상이어야 합니다.";
    private static final String MONEY_MULTIPLE_ERR_MSG = "구입 금액은 " + LOTTO_PRICE + "의 배수여야 합니다.";

    private final int money;

    public Payment(int money) {
        this.money = money;
        validate();
    }

    private void validate() {
        if (money < LOTTO_PRICE) {
            throw new IllegalArgumentException(MIN_MONEY_ERR_MSG);
        }
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(MONEY_MULTIPLE_ERR_MSG);
        }
    }

    public int getLottoCount() {
        return money / LOTTO_PRICE;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Payment payment = (Payment)obj;
        return money == payment.money;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }
}
