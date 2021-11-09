package lotto.domain;

import lotto.exception.MinimumTicketPriceException;
import lotto.ui.LottoMessage;

public class PurchaseInfo {
    public static final Money LOTTO_BASE_MONEY = Money.of(1_000);

    private final Money totalMoney;
    private final Money manualMoney;

    public PurchaseInfo(int buyPrice) {
        this(buyPrice, 0);
    }

    public PurchaseInfo(int buyPrice, int manualCount) {
        this.totalMoney = Money.of(buyPrice);
        this.manualMoney = Money.of(manualCount, LOTTO_BASE_MONEY);
        validateBuyPrice();
        validateNotExceedAmountSize();
    }

    private void validateBuyPrice() {
        if (LOTTO_BASE_MONEY.isExceedMoney(totalMoney)) {
            throw new MinimumTicketPriceException(LottoMessage.MINIMUM_TICKET_PRICE_MESSAGE);
        }
    }

    private void validateNotExceedAmountSize() {
        if((manualMoney.isExceedMoney(totalMoney))) {
            throw new IllegalArgumentException(LottoMessage.EXCEED_MANUAL_LOTTO_SIZE_MESSAGE);
        }
    }

    public int getTotalAmount() {
        return totalMoney.getAmount(LOTTO_BASE_MONEY);
    }

    public int getManualAmount() {
        return manualMoney.getAmount(LOTTO_BASE_MONEY);
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
