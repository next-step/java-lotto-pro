package lotto.domain.buyer;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;
import lotto.domain.money.Money;
import lotto.domain.seller.LottoSeller;
import lotto.dto.LottoBill;
import lotto.dto.StatisticResult;
import lotto.prize.Prize;

import java.math.BigDecimal;
import java.util.Map;

public class LottoBuyer {

    private static final int DECIMAL_POINT = 2;
    private final Money money;
    private Lottos lottos;

    public LottoBuyer(Money money) {
        this.money = money;
    }

    public LottoBill buyLotto(LottoSeller lottoSeller) {
        LottoBill lottoBill = lottoSeller.sellAutoLotto(money);
        initInfo(lottoBill);
        return lottoBill;
    }

    protected void initInfo(LottoBill lottoBill) {
        this.lottos = new Lottos(lottoBill.getLottos());
    }

    public StatisticResult calculateYieldStatistic(Lotto winnerLotto) {
        Map<Prize, Integer> prizeStatistic = lottos.getPrizeOfLotto(winnerLotto);
        BigDecimal yield = calculateYield(prizeStatistic);
        return new StatisticResult(prizeStatistic, yield);
    }

    private BigDecimal calculateYield(Map<Prize, Integer> prizeStatistic) {
        BigDecimal rewardSum = prizeStatistic.entrySet().stream().map(v -> {
            BigDecimal reward = v.getKey().getPrizeMoney();
            return reward.multiply(BigDecimal.valueOf(v.getValue()));
        }).reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
        return rewardSum.divide(BigDecimal.valueOf(money.useMoney()), DECIMAL_POINT, BigDecimal.ROUND_FLOOR);
    }

}
