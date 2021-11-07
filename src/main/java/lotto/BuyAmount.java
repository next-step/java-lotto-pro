package lotto;

import lotto.exception.MinimumTicketPriceException;
import lotto.ui.LottoMessage;

public class BuyAmount {
    public static final int LOTTO_TICKET_PRICE = 1000;

    private final int amount;

    public BuyAmount(int buyPrice) {
        validateBuyPrice(buyPrice);
        this.amount = buyPrice / LOTTO_TICKET_PRICE;
    }

    private void validateBuyPrice(int buyPrice) {
        if (buyPrice < LOTTO_TICKET_PRICE) {
            throw new MinimumTicketPriceException(LottoMessage.MINIMUM_TICKET_PRICE_MESSAGE);
        }
    }

    public int getAmount() {
        return amount;
    }

    public int getPrice() {
        return amount * LOTTO_TICKET_PRICE;
    }

    public double getProfitRate(long totalReward) {
        double basePrice = getPrice();
        return (totalReward - basePrice) / basePrice;
    }
}
