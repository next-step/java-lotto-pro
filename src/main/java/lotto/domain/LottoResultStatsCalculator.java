package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public final class LottoResultStatsCalculator {

    private final List<LottoTicket> lottoTickets;
    private final LottoNumbers winingLottoNumbers;
    private final LottoNumber bonusLottoNumber;

    public LottoResultStatsCalculator(
        final List<LottoTicket> lottoTickets,
        final LottoNumbers winingLottoNumbers,
        final LottoNumber bonusLottoNumber
    ) {
        this.lottoTickets = lottoTickets;
        this.winingLottoNumbers = winingLottoNumbers;
        this.bonusLottoNumber = bonusLottoNumber;
    }

    public LottoResultStatistics computeLottoResultStats() {
        final List<LottoResult> lottoResults = lottoTickets.stream()
            .map(LottoTicket::getLottoNumbers)
            .map(this::mapToLottoResult)
            .collect(Collectors.toList());
        return new LottoResultStatistics(lottoResults);
    }

    private LottoResult mapToLottoResult(final LottoNumbers lottoNumbers) {
        return LottoResult.valueOf(lottoNumbers.matchTo(winingLottoNumbers),
            lottoNumbers.contains(bonusLottoNumber));
    }

    public Double computeProfitRate() {
        final Money investedAmount = computeTotalLottoTicketsFee(lottoTickets);
        if (investedAmount.isLessThan(Money.ONE)) {
            return Money.ZERO.doubleValue();
        }
        final Money totalWiningAmount = computeLottoResultStats().getTotalWiningMoney();
        if (totalWiningAmount.isLessThan(Money.ONE)) {
            return Money.ZERO.doubleValue();
        }
        return totalWiningAmount.divide(investedAmount).doubleValue();
    }

    private static Money computeTotalLottoTicketsFee(final List<LottoTicket> lottoTickets) {
        return lottoTickets.stream()
            .map(LottoTicket::getFee)
            .reduce(Money.ZERO, Money::plus);
    }

}
