package lotto;

public class Money {

    private final int value;

    public Money(String money) {
        this.value = Integer.parseInt(money);
    }

    public int numberOfGames(int pricePerGame) {
        return value / pricePerGame;
    }
}
