package lotto.machine;

import lotto.Match.Match;

public class Result {

    private int threeCount = 0;
    private int fourCount = 0;
    private int fiveCount = 0;
    private int sixCount = 0;
    private int money = 0;
    private int yieldRate = 0;

    public void setMoney(int money){
        this.money = money;
    }

    public int getThreeCount() {
        return threeCount;
    }

    public int getFourCount() {
        return fourCount;
    }

    public int getFiveCount() {
        return fiveCount;
    }

    public int getSixCount() {
        return sixCount;
    }

    public void addCount(int matchCount) {
        if(matchCount == Match.THREE.getCount()){
            this.threeCount++;
        }
        if(matchCount == Match.FOUR.getCount()){
            this.fourCount++;
        }
        if(matchCount == Match.FIVE.getCount()){
            this.fiveCount++;
        }
        if(matchCount == Match.SIX.getCount()){
            this.sixCount++;
        }
    }

    public float yieldRate() {
        yieldRate += threeCount * Match.THREE.getAmount();
        yieldRate += fourCount * Match.FOUR.getAmount();
        yieldRate += fiveCount * Match.FIVE.getAmount();
        yieldRate += sixCount * Match.SIX.getAmount();
        return yieldRate / money;
    }
}
