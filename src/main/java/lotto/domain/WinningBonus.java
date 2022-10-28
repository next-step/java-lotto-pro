package lotto.domain;

public enum WinningBonus {
    THREE(3,5000),
    FOUR(4,50000),
    FIVE(5,1500000),
    SIX(6,2000000000);


    private final int matchCount;
    private final int bonus;

    WinningBonus(int matchCount, int bonus) {

        this.matchCount = matchCount;
        this.bonus = bonus;
    }

    public int getMatchCount(){
        return matchCount;
    }

    public int getBonus(){
        return bonus;
    }

    public boolean same(Integer c) {
        return this.getMatchCount() == c;
    }
}
