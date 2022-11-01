package study.step3.domain.lottostatistics;

import study.step3.domain.lotto.LottoRank;
import study.step3.domain.lotto.Money;
import study.step3.domain.lotto.PurchaseMoney;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class LottoStatistics {

    private static final int WINNING_DIVIDE_PURCHASE_MONEY_SCALE = 2;
    private final PurchaseMoney purchaseMoney;
    private final LottoRankCountCache rankCountCache;

    public LottoStatistics(PurchaseMoney purchaseMoney, LottoRankCountCache rankCountCache) {
        this.purchaseMoney = purchaseMoney;
        this.rankCountCache = rankCountCache;
    }

    public long findLottoRankCount(LottoRank lottoRank) {
        return rankCountCache.count(lottoRank);
    }

    public LottoRateOfReturn calculateRateOfReturn() {
        Money winningMoney = rankCountCache.sumWinningMoney();
        double rateOfReturn = BigDecimal.valueOf(winningMoney.money())
                .divide(BigDecimal.valueOf(purchaseMoney.money()), WINNING_DIVIDE_PURCHASE_MONEY_SCALE, RoundingMode.DOWN)
                .doubleValue();
        return new LottoRateOfReturn(rateOfReturn);
    }
}
