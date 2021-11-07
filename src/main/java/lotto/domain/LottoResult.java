package lotto.domain;

import java.math.BigDecimal;
import java.util.EnumMap;

import static lotto.domain.LottoMachine.GAME_PRICE;

public class LottoResult {

    private static final int DECIMAL_POINT = 3;

    private final EnumMap<Rank, Integer> lottoMatchResult;

    public LottoResult(EnumMap<Rank, Integer> lottoMatchResult) {
        this.lottoMatchResult = lottoMatchResult;
    }

    public int getMatchRankCount(Rank rank) {
        return lottoMatchResult.getOrDefault(rank, 0);
    }

    public double getLottoYield() {
        return getPrizeMoneySum().divide(getPurchaseAmount(GAME_PRICE))
                .setScale(DECIMAL_POINT)
                .doubleValue();
    }

    private BigDecimal getPrizeMoneySum() {
        BigDecimal sum = BigDecimal.valueOf(0);

        for (Rank rank : lottoMatchResult.keySet()) {
            BigDecimal multiply = rank.getPrizeMoney()
                    .getMoney()
                    .multiply(BigDecimal.valueOf(lottoMatchResult.get(rank)));

            sum = sum.add(multiply);
        }
        return sum;
    }

    private BigDecimal getPurchaseAmount(Money gamePrice) {
        return gamePrice.getMoney()
                .multiply(
                        BigDecimal.valueOf(lottoMatchResult.values()
                                .stream()
                                .mapToInt(Integer::intValue)
                                .sum())
                );
    }

}
