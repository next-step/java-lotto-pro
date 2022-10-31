package lotto.domain.matcher.count;

public class MatchCount {

    private int matchCount;
    private boolean isMatchBonus;

    public MatchCount(int matchCount, boolean isMatchBonus) {
        this.matchCount = matchCount;
        this.isMatchBonus = isMatchBonus;
    }

    public boolean isEquals(int matchCount) {
        int resultMatchCount = this.matchCount;
        if (isMatchBonus) {
            resultMatchCount = this.matchCount - 1;
        }
        return resultMatchCount == matchCount;
    }

    public boolean isMatchBonus() {
        return isMatchBonus;
    }
}
