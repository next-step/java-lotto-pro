package step3.dto;

import java.util.Objects;

import step3.domain.LottoRank;
import step3.domain.LottoRanks;

public class LottoResultDto {
    private final String rankName;
    private final int matchNumber;
    private final int matchCount;
    private final long prize;

    public LottoResultDto(LottoRanks.LottoRankResult lottoRankResult) {
        LottoRank lottoRank = lottoRankResult.getLottoRank();
        this.matchCount = lottoRankResult.getWinningCount();
        this.matchNumber = lottoRank.matchNumber;
        this.prize = lottoRank.prize;
        this.rankName = lottoRank.name();
    }

    public int getMatchNumber() {
        return matchNumber;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public String getRankName() {
        return rankName;
    }

    public long getPrize() {
        return prize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        LottoResultDto that = (LottoResultDto)o;
        return matchNumber == that.matchNumber && matchCount == that.matchCount && prize == that.prize
            && Objects.equals(rankName, that.rankName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rankName, matchNumber, matchCount, prize);
    }
}

