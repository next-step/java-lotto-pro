package lotto.domain.buyer;

import lotto.constant.LottoConstant;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;
import lotto.domain.money.Money;
import lotto.domain.seller.LottoSeller;
import lotto.prize.Prize;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class LottoBuyer {

    private static final int DECIMAL_POINT_POSITION = 2;
    private final Money money;

    public LottoBuyer(Money money) {
        this.money = money;
    }

    public Lottos buyLotto(LottoSeller lottoSeller) {
        List<Lotto> lottos = lottoSeller.sellAutoLotto(money);
        return new Lottos(lottos);
    }

    public BigDecimal calculateYield(Map<Prize, Integer> prizes, int lottoCount) {
        BigDecimal rewardSum = prizes.entrySet().stream().map(v -> {
            BigDecimal reward = v.getKey().getPrizeMoney();
            return reward.multiply(BigDecimal.valueOf(v.getValue()));
        }).reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
        return rewardSum.divide(BigDecimal.valueOf(lottoCount * LottoConstant.LOTTO_PRICE), DECIMAL_POINT_POSITION, BigDecimal.ROUND_FLOOR);
    }

}
