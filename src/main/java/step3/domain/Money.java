package step3.domain;


import java.util.Objects;

public class Money {

    private int money;
    private final String isLoss = "손해";
    private final String isBenefit = "이득";
    private final String CREATE_MONEY_EXCEPTION_MSG = "돈은 로또가격보다 큰 숫자여야합니다.(%s원)";
    private final int LOTTO_PRICE = 1_000;

    public Money(String money) {
        if (!validateMoneyRange(money)) {
            throw new IllegalArgumentException(String.format(CREATE_MONEY_EXCEPTION_MSG,LOTTO_PRICE));
        }
        this.money = Integer.parseInt(money);
    }

    public int purchaseTicket() {
        return money / LOTTO_PRICE;
    }

    private boolean validateMoneyRange(String money) {
        try {
            return Integer.parseInt(money) >= LOTTO_PRICE;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public String isBenefit(long reward) {
        if (money > reward) {
            return isLoss;
        }
        return isBenefit;
    }

    public double getProfitRate(long reward) {
        return reward * 1.0 / money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Money money1 = (Money) o;
        return money == money1.money;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }
}
