package step3.domain;

import java.util.HashMap;
import java.util.Map;

public class Statistics {
    private final LotteryTicket lotteryTicket;
    private final WinningBonusNumber winningBonusNumber;
    private Map<Rank, Integer> countByRank;
    
    public Statistics(LotteryTicket lotteryTicket, WinningBonusNumber winningBonusNumber) {
        this.lotteryTicket = lotteryTicket;
        this.winningBonusNumber = winningBonusNumber;
    }
    private void statisticsInit(){
        this.countByRank = new HashMap<>();
        for (Rank rank :Rank.values()) {
            putDefault(rank);
        }
    }

    private void putDefault(Rank rank) {
        if (!rank.isNone()) {
            this.countByRank.put(rank, 0);
        }
    }
    
    private void mapMerge(Rank rank) {
        if (!rank.isNone()) {
            this.countByRank.merge(rank, 1, Integer::sum);
        }
    }
    
    public Map<Rank, Integer> countByRank() {
        statisticsInit();
        for (Lotto lotto: this.lotteryTicket.getLotteryTicket()) {
            int matchCount = winningBonusNumber.getMatchCount(lotto);
            boolean isMatchBonusNumber = winningBonusNumber.checkBonusNumber(lotto);
            mapMerge(Rank.valueOf(matchCount, isMatchBonusNumber));
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
