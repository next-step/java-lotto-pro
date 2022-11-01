package lotto;

import java.util.ArrayList;
import java.util.List;

public final class LottoCustomer {

    private Money remainingAmount;
    private final List<LottoTicket> purchased;

    public LottoCustomer(final Money initialAmount) {
        this.remainingAmount = initialAmount;
        this.purchased = new ArrayList<>();
    }

    public boolean canPurchase(final LottoTicket lottoTicket) {
        return remainingAmount.isGreaterThanOrEqual(lottoTicket.getFee());
    }

    public Money purchase(final LottoTicket lottoTicket) {
        if (!canPurchase(lottoTicket)) {
            return Money.ZERO;
        }
        remainingAmount = remainingAmount.minus(lottoTicket.getFee());
        purchased.add(lottoTicket);
        return lottoTicket.getFee();
    }

    public int getPurchasedCount() {
        return purchased.size();
    }

    public Money getRemainingAmount() {
        return remainingAmount;
    }
}
