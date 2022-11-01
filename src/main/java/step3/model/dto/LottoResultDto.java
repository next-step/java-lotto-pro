package step3.model.dto;


import step3.model.LottoMoney;
import step3.model.Rank;

import java.util.Arrays;
import java.util.Map;

public class LottoResultDto {

    private final Map<Rank, Integer> rankOfLottos;
    private final double priceRatio;

    public LottoResultDto(Map<Rank, Integer> rankOfLottos, LottoMoney lottoMoney) {
        this.rankOfLottos = rankOfLottos;
        this.priceRatio = lottoMoney.getPriceRatio(Arrays.stream(Rank.values())
                .mapToInt(rank -> rank.getWinningPrice() * rankOfLottos.getOrDefault(rank, 0))
                .sum());
    }

    public double getPriceRatio() {
        return priceRatio;
    }

    public int getWinningCount(Rank rank) {
        return rankOfLottos.getOrDefault(rank, 0);
    }

}
