package lotto.domain;

public class Money {
    private static final int LOTTO_PRICE = 1000;
    private static final double MATH_ROUND_DIGIT = 100d;
    private static final String ERROR_MESSAGE_NOT_NUMBER = "숫자만 입력 가능합니다.";
    private static final String ERROR_MESSAGE_MIN_PRICE = "로또 1장 가격(" + LOTTO_PRICE + ") 보다 금액이 적어 구입할 수 없습니다.";

    private final int money;

    public Money(String money) {
        validateNumber(money);
        validateMinPrice(money);
        this.money = Integer.parseInt(money);
    }

    public Money(int money) {
        validateMinPrice(String.valueOf(money));
        this.money = money;
    }

    public boolean isMoreMoney(int money) {
        return this.money > money;
    }

    public boolean isLessMoney(int money) {
        return this.money < money;
    }

    public int findPurchaseTicketQuantity() {
        return money / LOTTO_PRICE;
    }

    public double profitRate(int totalPrizeMoney) {
        double totalPrizeMoneyDouble = totalPrizeMoney;
        double purchaseMoneyDouble = this.money;
        double profitRate = totalPrizeMoneyDouble / purchaseMoneyDouble;
        return Math.round(profitRate * MATH_ROUND_DIGIT) / MATH_ROUND_DIGIT;
    }

    private void validateNumber(String money) {
        try {
            Integer.parseInt(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NOT_NUMBER);
        }
    }

    private void validateMinPrice(String money) {
        if (Integer.parseInt(money) < LOTTO_PRICE) {
            throw new IllegalArgumentException(ERROR_MESSAGE_MIN_PRICE);
        }
    }
}
