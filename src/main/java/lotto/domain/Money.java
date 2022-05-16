package lotto.domain;

public class Money {

    private final int gamePrice;
    private final int value;

    public Money(String money, int gamePrice) {
        this.gamePrice = gamePrice;
        validateBounds(money);
        int value = Integer.parseUnsignedInt(money);
        validatePurchasable(value);
        this.value = value;
    }

    public int numberOfGames() {
        return value / gamePrice;
    }

    private void validateBounds(String money) {
        try {
            Integer.parseUnsignedInt(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("구입 금액은 자연수만 가능합니다.");
        }
    }

    private void validatePurchasable(int money) {
        if (money < gamePrice) {
            throw new IllegalArgumentException("최소 구입 가능 금액보다 작습니다");
        }
    }
}
