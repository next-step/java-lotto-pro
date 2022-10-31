package lotto.domain.buyer;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;
import lotto.domain.money.Money;
import lotto.domain.seller.LottoSeller;
import lotto.prize.Prizes;

import java.math.BigDecimal;
import java.util.List;

public class LottoBuyer {

    private static final int DECIMAL_POINT_POSITION = 2;
    private Money money;

    public LottoBuyer(Money money) {
        this.money = money;
    }

    public Lottos buyLotto(LottoSeller lottoSeller) {
        List<Lotto> lottos = lottoSeller.sellAutoLotto(money);
        return new Lottos(lottos);
    }

    public BigDecimal calculateYield(Prizes prizes) {
        BigDecimal rewardSum = prizes.sumReward();
        return rewardSum.divide(BigDecimal.valueOf(money.getInvestment()), DECIMAL_POINT_POSITION, BigDecimal.ROUND_FLOOR);
    }

}
