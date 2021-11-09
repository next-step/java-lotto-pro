package lotto.domain;

import lotto.exception.MinimumTicketPriceException;
import lotto.ui.LottoMessage;

public class BuyAmount {
    private final Money totalMoney;
    private final Money manualMoney;

    public BuyAmount(int buyPrice) {
        this(buyPrice, 0);
    }

    public BuyAmount(int buyPrice, int manualAmount) {
        validateBuyPrice(buyPrice);
        this.totalMoney = new Money(buyPrice);
        this.manualMoney = new Money(manualAmount * Money.LOTTO_TICKET_PRICE);
        validateNotExceedAmountSize();
    }

    private void validateBuyPrice(int buyPrice) {
        if (buyPrice < Money.LOTTO_TICKET_PRICE) {
            throw new MinimumTicketPriceException(LottoMessage.MINIMUM_TICKET_PRICE_MESSAGE);
        }
    }

    private void validateNotExceedAmountSize() {
        if((totalMoney.isExceedMoney(manualMoney))) {
            throw new IllegalArgumentException(LottoMessage.EXCEED_MANUAL_LOTTO_SIZE_MESSAGE);
        }
    }

    public int getTotalAmount() {
        return totalMoney.getPrice() / Money.LOTTO_TICKET_PRICE;
    }

    public int getManualAmount() {
        return manualMoney.getPrice() / Money.LOTTO_TICKET_PRICE;
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
