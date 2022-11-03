package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public class Result {
    private int prizeMoney;
    public Map<Rank, Integer> winningMap;
    public double returnRate;

    public Result() {
        this.winningMap = new EnumMap<>(Rank.class);
        Arrays.stream(Rank.values()).forEach(r -> {
            winningMap.put(r, 0);
        });
        
        this.prizeMoney = 0;
    }

    public void checkPrizeMoney(int correctCount, boolean matchBonus) {
        Rank rank = Rank.valueOf(correctCount, matchBonus);
        
        if(rank != null) {
            winningMap.put(rank, winningMap.get(rank) + 1);
            this.prizeMoney += rank.getWinningMoney();
        }
    }

    public void checkResultRate(Money usedMoney) {
        double returnRate = (double) this.prizeMoney / usedMoney.amount;
        this.returnRate = Math.floor(returnRate * 100) / 100;
    }
}
