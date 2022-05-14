package lotto.domain;

public class Money {
    public static final int LOTTO_PRICE = 1000;
    private int amount;

    public Money(int amount){
        this.amount = validateMoney(amount);
    }

    private int validateMoney(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("[Error] 음수는 불가합니다.");
        }
        return amount;
    }

    public int getAmount() {
        return amount;
    }

    public int lottoCountToBuy() {
        return amount/ LOTTO_PRICE;
    }
}
