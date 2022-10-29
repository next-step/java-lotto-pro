package lotto;

public class Money {

    private int amount;

    public Money(int amount) {
        this.amount = amount;
    }

    public Money(String amount) {
        try {
            this.amount = Integer.parseInt(amount);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("금액은 숫자여야 합니다");
        }
    }

    public void minus(int minusAmount) {
        if (amount >= minusAmount) {
            amount -= minusAmount;
        }
    }

    public int getAmount() {
        return amount;
    }

    public boolean isEqualsOrGreater(int operandAmount) {
        return amount >= operandAmount;
    }
}
