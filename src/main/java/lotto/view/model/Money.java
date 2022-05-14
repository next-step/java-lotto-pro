package lotto.view.model;

public class Money {
    private final int amount;

    private Money(int amount) {
        this.amount = amount;
    }

    public static Money of(int amount) {
        checkAmountRange(amount);
        return new Money(amount);
    }

    private static void checkAmountRange(int amount) {
        if (amount < 0) {
            String message = String.format("[ERROR] 구매금액은 음수일 수 없습니다! : [%d]", amount);
            throw new IllegalArgumentException(message);
        }
    }
}
