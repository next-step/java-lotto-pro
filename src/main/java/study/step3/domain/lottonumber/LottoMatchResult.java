package study.step3.domain.lottonumber;

public class LottoMatchResult implements Comparable<LottoMatchResult> {

    private final long matchCount;
    private final long bonusMatchCount;

    public LottoMatchResult(long matchCount, long bonusMatchCount) {
        this.matchCount = matchCount;
        this.bonusMatchCount = bonusMatchCount;
    }

    public boolean isGreaterThanOrEqualMatchCount(LottoMatchResult lottoMatchResult) {
        return this.matchCount >= lottoMatchResult.matchCount;
    }

    public boolean isEqualsLottoMatchCount(LottoMatchResult lottoMatchResult) {
        return this.matchCount == lottoMatchResult.matchCount;
    }

    public boolean isGreaterThanOrEqualBonusMatchCount(LottoMatchResult lottoMatchResult) {
        return this.bonusMatchCount >= lottoMatchResult.bonusMatchCount;
    }

    public boolean isGreaterThanZeroBonusMatchCount() {
        return this.bonusMatchCount > 0L;
    }

    public long lottoMatchCount() {
        return this.matchCount;
    }

    @Override
    public int compareTo(LottoMatchResult otherMatchCount) {
        if(isEqualsLottoMatchCount(otherMatchCount)) {
            return (int) (this.bonusMatchCount - otherMatchCount.bonusMatchCount);
        }

        return (int) (this.matchCount - otherMatchCount.matchCount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LottoMatchResult that = (LottoMatchResult) o;

        if (matchCount != that.matchCount) return false;
        return bonusMatchCount == that.bonusMatchCount;
    }

    @Override
    public int hashCode() {
        int result = (int) (matchCount ^ (matchCount >>> 32));
        result = 31 * result + (int) (bonusMatchCount ^ (bonusMatchCount >>> 32));
        return result;
    }
}
