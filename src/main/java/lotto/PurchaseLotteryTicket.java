package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PurchaseLotteryTicket {
    private List<LotteryTicket> purchaseLotteryTicket;

    public PurchaseLotteryTicket() {
        purchaseLotteryTicket = new ArrayList<>();
    }

    public void add(LotteryTicket lotteryTicket) {
        this.purchaseLotteryTicket.add(lotteryTicket);
    }

    public LotteryTicket get(int i) {
        return purchaseLotteryTicket.get(i);
    }

    public LotteryResult countMatchInAllTicket(WinningNumber winningNumber) {
        Map<Rank, Integer> result = new HashMap<>();
        for (LotteryTicket lotteryTicket : purchaseLotteryTicket) {
            Rank rank = Rank.valueOf(lotteryTicket.countMatch(winningNumber));
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        }
        return LotteryResult.saveLotteryResult(result);
    }
}
