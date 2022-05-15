package lotto.dto;

public class LottoResultItem {
    private final int match;
    private final int prizeMoney;
    private final int count;

    public LottoResultItem(int match, int prizeMoney, int count) {
        this.match = match;
        this.prizeMoney = prizeMoney;
        this.count = count;
    }

    public int getMatch() {
        return match;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public int getCount() {
        return count;
    }
}
