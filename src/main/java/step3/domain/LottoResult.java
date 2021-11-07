package step3.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class LottoResult {
    private final LottoRanks lottoRanks;
    private final Amount amount;

    public LottoResult(LottoRanks lottoRanks, Amount amount) {
        this.lottoRanks = lottoRanks;
        this.amount = amount;
    }

    public BigDecimal getCalculatedYield() {
        Long totalPrize = lottoRanks.totalPrize();
        
        return BigDecimal.valueOf(totalPrize)
            .divide(BigDecimal.valueOf(amount.getAmount()))
            .setScale(2, RoundingMode.CEILING);
    }

    public LottoRanks getLottoRanks() {
        return lottoRanks;
    }

    public Long getTotalPrize() {
        return lottoRanks.totalPrize();
    }

}
