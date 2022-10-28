package step3.model.dto;


import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LottoResultDto {
    private final List<RankDto> ranks;
    private final double priceRatio;

    public LottoResultDto(List<RankDto> ranks, double priceRatio) {
        this.ranks = ranks;
        this.priceRatio = priceRatio;
    }

    public List<RankDto> getRanks() {
        return ranks.stream()
                .sorted(Comparator.comparingInt(RankDto::getMatchCount))
                .filter(RankDto::isWin)
                .collect(Collectors.toList());
    }

    public double getPriceRatio() {
        return priceRatio;
    }
}
