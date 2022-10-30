package step3.domain;

import java.util.*;

public class Statistics {
    private final LotteryTicket lotteryTicket;
    private final WinningNumber winningNumber;
    private Map<Rank, Integer> countByRank;
    
    public Statistics(LotteryTicket lotteryTicket, WinningNumber winningNumber) {
        this.lotteryTicket = lotteryTicket;
        this.winningNumber = winningNumber;
    }
    private void statisticsInit(){
        this.countByRank = new HashMap<>();
        for (Rank rank :Rank.values()) {
            putDefault(rank);
        }
    }
    
    private void putDefault(Rank rank) {
        if(!rank.isNone()){
            this.countByRank.put(rank, 0);
        }
    }
    
    private void mapMerge(Rank rank) {
        if(!rank.isNone()){
            this.countByRank.merge(rank, 1 , Integer::sum);
        }
    }
    
    public Map<Rank, Integer> countByRank() {
        statisticsInit();
        for (Lotto lotto: this.lotteryTicket.getLotteryTicket()) {
            int matchCount = lotto.compareMath(this.winningNumber);
            mapMerge(Rank.valueOf(matchCount, false));
        }
        return this.countByRank;
    }
    
    public long totalPrize() {
        long totalPrize = 0;
        Map<Rank, Integer> countByRank = countByRank();
        for (Rank rank : countByRank.keySet()) {
            totalPrize += countByRank.get(rank) * rank.getPrize();
        }
    
        return totalPrize;
    }
}
