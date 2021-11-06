package lotto;

import lotto.exception.MinimumTicketPriceException;

public class BuyAmount {
    private static final String MINIMUM_TICKET_PRICE_MESSAGE = "구입 금액을 확인해 주세요.";
    public static final int LOTTO_TICKET_PRICE = 1000;

    private final int amount;

    public BuyAmount(int buyPrice) {
        validateBuyPrice(buyPrice);
        this.amount = buyPrice / LOTTO_TICKET_PRICE;
    }

    private void validateBuyPrice(int buyPrice) {
        if (buyPrice < LOTTO_TICKET_PRICE) {
            throw new MinimumTicketPriceException(MINIMUM_TICKET_PRICE_MESSAGE);
        }
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
