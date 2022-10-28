package step3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LotteryTicket {
    private final List<Lotto> lotteryTicket = new ArrayList<>();
    private final ArrayList<Integer> winningNumbers;
    
    public LotteryTicket(ArrayList<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public List<Lotto> getLotteryTicket() {
        return this.lotteryTicket;
    }
    
    public void add(Lotto lotto) {
        this.lotteryTicket.add(lotto);
    }
    
    public Map<Rank, Integer> countByRank() {
        Map<Rank, Integer> countByRank = new HashMap<>();
        for (Lotto lotto: this.lotteryTicket) {
            countByRank.merge(Rank.getRank(lotto.compareMath(this.winningNumbers)), 1 , Integer::sum);
        }
        
        return countByRank;
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
