package study.step3.domain.lottonumber;

public class LottoMatchResult implements Comparable<LottoMatchResult> {

    private final long matchCount;
    private final boolean isMatchedBonusLottoNumber;

    public LottoMatchResult(long matchCount, boolean isMatchedBonusLottoNumber) {
        this.matchCount = matchCount;
        this.isMatchedBonusLottoNumber = isMatchedBonusLottoNumber;
    }

    public boolean isGreaterThanOrEqualMatchCount(LottoMatchResult lottoMatchResult) {
        return this.matchCount >= lottoMatchResult.matchCount;
    }

    public boolean isEqualsLottoMatchCount(LottoMatchResult lottoMatchResult) {
        return this.matchCount == lottoMatchResult.matchCount;
    }

    public boolean isEqualBonusMatch(LottoMatchResult lottoMatchResult) {
        return this.isMatchedBonusLottoNumber == lottoMatchResult.isMatchedBonusLottoNumber;
    }

    public boolean isMatchedBonusLottoNumber() {
        return this.isMatchedBonusLottoNumber;
    }

    public long lottoMatchCount() {
        return this.matchCount;
    }

    @Override
    public int compareTo(LottoMatchResult otherMatchCount) {
        if(isEqualsLottoMatchCount(otherMatchCount)) {
            return Boolean.compare(this.isMatchedBonusLottoNumber, otherMatchCount.isMatchedBonusLottoNumber);
        }

        return (int) (this.matchCount - otherMatchCount.matchCount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LottoMatchResult that = (LottoMatchResult) o;

        if (matchCount != that.matchCount) return false;
        return isMatchedBonusLottoNumber == that.isMatchedBonusLottoNumber;
    }

    @Override
    public int hashCode() {
        int result = (int) (matchCount ^ (matchCount >>> 32));
        result = 31 * result + (isMatchedBonusLottoNumber ? 1 : 0);
        return result;
    }
}
