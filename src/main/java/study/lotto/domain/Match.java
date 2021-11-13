package study.lotto.domain;

public class Match {
    private int count;
    private boolean matchBonus;

    public Match(int count, boolean matchBonus) {
        this.count = count;
        this.matchBonus = matchBonus;
    }

    public void increaseCount() {
        this.count++;
    }

    public int getCount() {
        return this.count;
    }

    public boolean getMatchBonus() {
        return this.matchBonus;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setMatchBonus(boolean isMatch) {
        this.matchBonus = isMatch;
    }


}
