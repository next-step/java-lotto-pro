package study.lotto.domain;

public class Match {

    private static final int INITIAL_MATCH_COUNT = 0;
    private static final boolean INITIAL_MATCH_BONUS = false;

    private int count;
    private boolean matchBonus;

    public Match() {
        this.count = INITIAL_MATCH_COUNT;
        this.matchBonus = INITIAL_MATCH_BONUS;
    }

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
