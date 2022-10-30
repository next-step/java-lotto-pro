package lotto.machine;

import lotto.match.Rank;

public class Result {
    private int firstCount = 0;
    private int secondCount = 0;
    private int threeCount = 0;
    private int fourCount = 0;
    private int fiveCount = 0;
    private int money = 0;
    private int yieldRate = 0;

    public void addCount(int matchCount, boolean matchBonus) {
        if(matchCount == Rank.FIRST.getCountOfMatch()){
            this.firstCount++;
        }
        if(matchBonus && matchCount == Rank.SECOND.getCountOfMatch()){
            this.secondCount++;
        }
        if(!matchBonus && matchCount == Rank.THIRD.getCountOfMatch()){
            this.threeCount++;
        }
        if(matchCount == Rank.FOURTH.getCountOfMatch()){
            this.fourCount++;
        }
        if(matchCount == Rank.FIFTH.getCountOfMatch()){
            this.fiveCount++;
        }
    }

    public float yieldRate() {
        yieldRate += firstCount * Rank.FIRST.getAmount();
        yieldRate += secondCount * Rank.SECOND.getAmount();
        yieldRate += threeCount * Rank.THIRD.getAmount();
        yieldRate += fourCount * Rank.FOURTH.getAmount();
        yieldRate += fiveCount * Rank.FIFTH.getAmount();
        return yieldRate / money;
    }

    public void setMoney(int money){
        this.money = money;
    }

    public int getThreeCount() {
        return threeCount;
    }

    public int getFourCount() {
        return fourCount;
    }

    public int getSecondCount() {
        return secondCount;
    }

    public int getFirstCount() {
        return firstCount;
    }

    public int getFiveCount(){
        return fiveCount;
    }
}
