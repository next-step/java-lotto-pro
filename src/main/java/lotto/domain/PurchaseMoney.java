package lotto.domain;

public class PurchaseMoney {
    private static final String ERROR_MESSAGE_MONEY_NEGATIVE = "[ERROR] 금액은 음수가 될 수 없습니다";
    private static final String ERROR_MESSAGE_MONEY_LOWER_THAN_PRICE = "[ERROR] 금액이 로또 가격 미만입니다.";
    
    private static final int LOTTO_PRICE = 1000;

    private final int money;
    private final int amountOfLotto;
    
    public PurchaseMoney(int money) {
        validate(money);

        this.money = money;
        this.amountOfLotto = money / LOTTO_PRICE;
    }

    public int getMoney() {
        return money;
    }

    public int getAmountOfLotto() {
        return amountOfLotto;
    }

    private void validate(int money) {
        validateNegative(money);
        validatePrice(money);
    }
    
    private void validateNegative(int money) {
        if(money < 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE_MONEY_NEGATIVE);
        }
    }

    private void validatePrice(int money) {
        if(money < LOTTO_PRICE) {
            throw new IllegalArgumentException(ERROR_MESSAGE_MONEY_LOWER_THAN_PRICE);
        }
    }

    public double calculateEarningsRate(int resultMoney) {
        return (double)resultMoney / money;
    }
}
