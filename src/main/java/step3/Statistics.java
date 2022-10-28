package step3;

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
        if(rank != Rank.NONE){
            this.countByRank.put(rank, 0);
        }
    }
    
    private void mapMerge(Rank rank) {
        if(rank != Rank.NONE){
            this.countByRank.merge(rank, 1 , Integer::sum);
        }
    }
    
    public Map<Rank, Integer> countByRank() {
        statisticsInit();
        for (Lotto lotto: this.lotteryTicket.getLotteryTicket()) {
            mapMerge(Rank.getRank(lotto.compareMath(this.winningNumber)));
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
