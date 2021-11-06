package step3.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class LottoResult {
    private final LottoRanks lottoRanks;

    private final BigDecimal yield;

    public LottoResult(LottoRanks lottoRanks, Amount amount) {
        this.lottoRanks = lottoRanks;
        System.out.println(lottoRanks.totalPrize());
        System.out.println(amount.getAmount());

        this.yield = BigDecimal.valueOf(lottoRanks.totalPrize())
            .divide(BigDecimal.valueOf(amount.getAmount()))
            .setScale(2, RoundingMode.CEILING);
    }

    public LottoRanks getLottoRanks() {
        return lottoRanks;
    }

    public BigDecimal getYield() {
        return yield;
    }
}
