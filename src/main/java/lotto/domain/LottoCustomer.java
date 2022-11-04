package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public final class LottoCustomer {

    private final Wallet wallet;
    private final List<LottoTicket> purchased;
    private LottoNumbers winingLottoNumbers;

    public LottoCustomer(final Money initialAmount) {
        this.wallet = new Wallet(initialAmount);
        this.purchased = new ArrayList<>();
        this.winingLottoNumbers = null;
    }

    public boolean canPurchase(final LottoTicket lottoTicket) {
        return wallet.hasAmount(lottoTicket.getFee());
    }

    public Money purchase(final LottoTicket lottoTicket) {
        if (!canPurchase(lottoTicket)) {
            return Money.ZERO;
        }
        wallet.minusAmount(lottoTicket.getFee());
        purchased.add(lottoTicket);
        return lottoTicket.getFee();
    }

    public void setWiningLottoNumbers(final LottoNumbers winingLottoNumbers) {
        this.winingLottoNumbers = winingLottoNumbers;
    }

    public List<LottoNumbers> getPurchasedLottoNumbers() {
        return purchased.stream()
            .map(LottoTicket::getLottoNumbers)
            .collect(Collectors.toList());
    }

    public LottoResultStatistics getResultStats() {
        return new LottoResultStatistics(getLottoResults());
    }

    public Double getProfitRate() {
        final Money invested = wallet.getUsedAmount();
        final Money earned = getEarnedAmount();
        if (invested.isLessThan(Money.ONE)
            || earned.isLessThan(Money.ONE)) {
            return Money.ZERO.doubleValue();
        }
        return earned.divide(invested).doubleValue();
    }

    public int getPurchasedCount() {
        return purchased.size();
    }

    private Money getEarnedAmount() {
        return getLottoResults().stream()
            .map(LottoResult::getPrizeMoney)
            .reduce(Money.ZERO, Money::plus);
    }

    private List<LottoResult> getLottoResults() {
        return getLottoNumberMatchCounts().stream()
            .map(LottoResult::fromLottoNumberMatchCount)
            .collect(Collectors.toList());
    }

    private List<LottoNumberMatchCount> getLottoNumberMatchCounts() {
        if (winingLottoNumbers == null) {
            return Collections.emptyList();
        }
        return purchased.stream()
            .map(lottoTicket -> winingLottoNumbers.matchTo(lottoTicket.getLottoNumbers()))
            .collect(Collectors.toList());
    }

}
