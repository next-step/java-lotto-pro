package lotto.domain;

public class Money {

    private final int value;

    public Money(String money) {
        validateUnsignedInt(money);
        int value = Integer.parseUnsignedInt(money);
        validateNotZero(value);
        this.value = value;
    }

    private void validateUnsignedInt(String money) {
        try {
            Integer.parseUnsignedInt(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("구입 금액은 자연수만 가능합니다.");
        }
    }

    private void validateNotZero(int value) {
        if (value == 0) {
            throw new IllegalArgumentException("구입 금액은 0보다 커야 합니다.");
        }
    }

    public int numberOfGames(int gamePrice) {
        return value / gamePrice;
    }
}
