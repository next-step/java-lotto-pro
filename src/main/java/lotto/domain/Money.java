package lotto.domain;

public class Money {
    public static final int LOTTO_PRICE = 1000;
    private int amount;

    public Money(String amount){
        this.amount = stringToValidMoney(amount);
    }

    private int stringToValidMoney(String amount) {
        try {
            return validateMoney(Integer.parseInt(amount));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[Error] 올바른 숫자 형식이 아닙니다.");
        }
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
}
