package step3.model;

public class Money {
    private static final int TICKET_PRICE = 1000;
    private static final int MINIMUM_PRICE = 0;
    private final int money;

    public Money(int money) {
        validateMoney(money);
        this.money = money;
    }

    private void validateMoney(int money) {
        if (money <= MINIMUM_PRICE || money % TICKET_PRICE != MINIMUM_PRICE) {
            throw new IllegalArgumentException("해당 금액으로는 티켓을 구매할 수 없습니다.");
        }
    }

    public int countOfLottoPurchases() {
        return money / TICKET_PRICE;
    }
}
