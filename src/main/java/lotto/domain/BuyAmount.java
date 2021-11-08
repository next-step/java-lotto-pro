package lotto.domain;

import lotto.exception.MinimumTicketPriceException;
import lotto.ui.LottoMessage;

public class BuyAmount {
    public static final int LOTTO_TICKET_PRICE = 1000;

    private final int amount;
    private final int manualAmount;

    public BuyAmount(int buyPrice) {
        this(buyPrice, 0);
    }

    public BuyAmount(int buyPrice, int manualAmount) {
        validateBuyPrice(buyPrice);
        this.amount = buyPrice / LOTTO_TICKET_PRICE;
        validateNotExceedAmountSize(manualAmount);
        this.manualAmount = manualAmount;
    }

    private void validateBuyPrice(int buyPrice) {
        if (buyPrice < LOTTO_TICKET_PRICE) {
            throw new MinimumTicketPriceException(LottoMessage.MINIMUM_TICKET_PRICE_MESSAGE);
        }
    }

    private void validateNotExceedAmountSize(int manualAmount) {
        if((amount < manualAmount)) {
            throw new IllegalArgumentException(LottoMessage.EXCEED_MANUAL_LOTTO_SIZE_MESSAGE);
        }
    }

    public int getAmount() {
        return amount;
    }

    public int getManualAmount() {
        return manualAmount;
    }

    public int getAutoAmount() {
        return amount - manualAmount;
    }

    public int getPrice() {
        return amount * LOTTO_TICKET_PRICE;
    }

    public double getProfitRate(long totalReward) {
        double basePrice = getPrice();
        return (totalReward - basePrice) / basePrice;
    }
}
