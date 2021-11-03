package lotto;

public class Money {
    public static final int PRICE_ONE_LOTTO = 1000;
    private int amount;

    public Money(int amount) {
        validateMinimumAmount(amount);
        this.amount = amount;
    }

    private void validateMinimumAmount(int amount) {
        if (amount < PRICE_ONE_LOTTO) {
            throw new RuntimeException("최소 금액 1000원보다 작은 금액을 입력하였습니다.");
        }
    }

    public int getLottoCount() {
        return this.amount / PRICE_ONE_LOTTO;
    }
}
