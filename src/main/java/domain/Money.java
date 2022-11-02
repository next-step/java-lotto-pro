package domain;

public class Money {
    private static final int DEFAULT_LOTTO_PRICE = 1000;
    private static final int MIN_MONEY = 0;

    private final int money;

    public Money(int money) {
        isValidMoney(money);
        this.money = money;
    }

    public int countOfLottoTicket() {
        return money / DEFAULT_LOTTO_PRICE;
    }

    private void isValidMoney(int money) {
        isValidPriceRange(money);
        isValidThousandWon(money);
    }

    private void isValidPriceRange(int money) {
        if (money <= MIN_MONEY) {
            throw new IllegalArgumentException("티켓 구매 가격은 0원 이하가 될 수 없습니다.");
        }
    }

    private void isValidThousandWon(int money) {
        if (money % DEFAULT_LOTTO_PRICE != MIN_MONEY) {
            throw new IllegalArgumentException("티켓 구매 가격은 천원단위로 가능 합니다.");
        }
    }

}
