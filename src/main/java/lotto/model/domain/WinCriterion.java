package lotto.model.domain;

import lotto.model.constants.ErrorMessage;

public class WinCriterion implements Comparable<WinCriterion> {

    private int rank; // 등수
    private int matchCount; // 일치하는 숫자 개수
    private long prize; // 상금

    public WinCriterion(int rank, int matchCount, long prize) {
        if (validateRank(rank)) {
            this.rank = rank;
        }
        if (validateMatchCount(matchCount)) {
            this.matchCount = matchCount;
        }
        if (validatePrize(prize)) {
            this.prize = prize;
        }
    }

    private boolean validateRank(int rank) {
        if (rank <= 0) {
            throw new IllegalArgumentException(ErrorMessage.RANK_NOT_POSITIVE);
        }
        return true;
    }

    private boolean validateMatchCount(int matchCount) {
        if (matchCount < 0) {
            throw new IllegalArgumentException(ErrorMessage.MATCH_COUNT_NEGATIVE);
        }
        return true;
    }

    private boolean validatePrize(long prize) {
        if (prize <= 0) {
            throw new IllegalArgumentException(ErrorMessage.PRIZE_NOT_POSITIVE);
        }
        return true;
    }

    public boolean compareMatchCount(int matchCount) {
        return this.matchCount == matchCount;
    }

    public long calculatePrize(int count) {
        return this.prize * count;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public long getPrize() {
        return prize;
    }

    @Override
    public int compareTo(WinCriterion o) {
        return o.rank - this.rank;
    }
}
