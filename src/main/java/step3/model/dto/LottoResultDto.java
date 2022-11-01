package step3.model.dto;


import step3.model.LottoMoney;
import step3.model.Rank;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoResultDto {
    private final List<RankDto> ranks;
    private final double priceRatio;

    public LottoResultDto(Map<Rank, Integer> rankOfLottos, LottoMoney lottoMoney) {
        this.ranks = Arrays.stream(Rank.values())
                .map(rank -> new RankDto(rank, rankOfLottos.getOrDefault(rank, 0)))
                .collect(Collectors.toList());
        this.priceRatio = lottoMoney.getPriceRatio(Arrays.stream(Rank.values())
                .mapToInt(rank -> rank.getWinningPrice() * rankOfLottos.getOrDefault(rank, 0))
                .sum());
    }

    public List<RankDto> getRanks() {
        return ranks;
    }

    public double getPriceRatio() {
        return priceRatio;
    }
}
