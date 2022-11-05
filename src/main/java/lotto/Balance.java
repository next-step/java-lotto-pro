package lotto;

import static lotto.Constant.LOTTO_PRICE;

import java.util.Objects;

public class Balance {
    private int balance;

    public Balance(int balance) {
        Validate.validateOnlyNumber(String.valueOf(balance));
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public int getPurchasableCount() {
        return balance / LOTTO_PRICE;
    }

    public void minusBalance() {
        balance -= LOTTO_PRICE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Balance balance1 = (Balance) o;
        return balance == balance1.balance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(balance);
    }
}
