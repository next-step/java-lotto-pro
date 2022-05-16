package lotto;

public class Money {

    public static final int PRICE = 1000;
    private final int value;

    public Money(String money) {
        validateBounds(money);
        int value = Integer.parseUnsignedInt(money);
        validatePurchasable(value);
        this.value = value;
    }

    public int numberOfGames(int pricePerGame) {
        return value / pricePerGame;
    }

    private void validateBounds(String money) {
        try {
            Integer.parseUnsignedInt(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("구입 금액은 자연수만 가능합니다.");
        }
    }

    private void validatePurchasable(int money) {
        if (money < PRICE) {
            throw new IllegalArgumentException("최소 구입 가능 금액보다 작습니다");
        }
    }
}
