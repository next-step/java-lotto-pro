package lotto.domain;

import lotto.exception.MinimumTicketPriceException;
import lotto.ui.LottoMessage;

public class BuyAmount {
    public static final int LOTTO_TICKET_PRICE = 1000;

    private final Money totalMoney;
    private final Money manualMoney;

    public BuyAmount(int buyPrice) {
        this(buyPrice, 0);
    }

    public BuyAmount(int buyPrice, int manualAmount) {
        validateBuyPrice(buyPrice);
        this.totalMoney = new Money(buyPrice);
        this.manualMoney = new Money(manualAmount * LOTTO_TICKET_PRICE);
        validateNotExceedAmountSize();
    }

    private void validateBuyPrice(int buyPrice) {
        if (buyPrice < LOTTO_TICKET_PRICE) {
            throw new MinimumTicketPriceException(LottoMessage.MINIMUM_TICKET_PRICE_MESSAGE);
        }
    }

    private void validateNotExceedAmountSize() {
        if((totalMoney.isExceedMoney(manualMoney))) {
            throw new IllegalArgumentException(LottoMessage.EXCEED_MANUAL_LOTTO_SIZE_MESSAGE);
        }
    }

    public int getTotalAmount() {
        return totalMoney.getPrice() / LOTTO_TICKET_PRICE;
    }

    public int getManualAmount() {
        return manualMoney.getPrice() / LOTTO_TICKET_PRICE;
    }

    public int getAutoAmount() {
        return getTotalAmount() - getManualAmount();
    }

    public int getPrice() {
        return totalMoney.getPrice();
    }

    public double getProfitRate(long totalReward) {
        double basePrice = getPrice();
        return (totalReward - basePrice) / basePrice;
    }
}
