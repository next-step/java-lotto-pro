package step3.dto;

import java.util.Objects;

public class LottoResultDto {
    private final String rankName;
    private final int matchNumber;
    private final int matchCount;
    private final long prize;

    public LottoResultDto(int matchNumber, long prize, String rankName, int matchCount) {
        this.matchNumber = matchNumber;
        this.matchCount = matchCount;
        this.prize = prize;
        this.rankName = rankName;
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

    public long getPrize() {
        return prize;
    }
}

