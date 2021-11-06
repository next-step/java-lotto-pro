package lotto;

public class BuyAmount {
    public static final int LOTTO_TICKET_PRICE = 1000;

    private final int amount;

    public BuyAmount(int buyPrice) {
        this.amount = buyPrice / LOTTO_TICKET_PRICE;
    }

    public int getAmount() {
        return amount;
    }

    public int getPrice() {
        return amount * LOTTO_TICKET_PRICE;
    }

    public double getProfitRate(int totalReward) {
        double basePrice = getPrice();
        return (totalReward - basePrice) / basePrice;
    }
}
