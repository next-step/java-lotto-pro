package step3.model.dto;


import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LottoResultDto {
    private final List<RankDto> ranks;
    private final int price;

    public LottoResultDto(List<RankDto> ranks, int price) {
        this.ranks = ranks;
        this.price = price;
    }

    public List<RankDto> getRanks() {
        return ranks.stream()
                .sorted(Comparator.comparingInt(RankDto::getMatchCount))
                .filter(rankDto -> rankDto.getMatchCount() > 0)
                .collect(Collectors.toList());
    }

    public double getWinnigPercent() {
        return ranks.stream()
                .mapToInt(rank -> rank.getWinningCount() * rank.getWinningPrice())
                .sum() / (double) price;
    }
}
