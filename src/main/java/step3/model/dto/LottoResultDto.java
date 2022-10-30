package step3.model.dto;


import java.util.List;

public class LottoResultDto {
    private final List<RankDto> ranks;
    private final double priceRatio;

    public LottoResultDto(List<RankDto> ranks, double priceRatio) {
        this.ranks = ranks;
        this.priceRatio = priceRatio;
    }

    public List<RankDto> getRanks() {
        return ranks;
    }

    public double getPriceRatio() {
        return priceRatio;
    }
}
