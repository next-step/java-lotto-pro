package step3;

import java.util.ArrayList;
import java.util.List;

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
    
    public long getTotalPrize() {
        long totalPrize = 0;
        for (Lotto lotto: this.lotteryTicket) {
            lotto.compareMath(this.winningNumbers);
            totalPrize += Rank.getPrize(lotto.getMatchCount());
        }
        
        return totalPrize;
    }
}
