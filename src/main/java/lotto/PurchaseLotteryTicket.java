package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PurchaseLotteryTicket {
    private List<LotteryNumbers> purchaseLotteryTicket;

    public PurchaseLotteryTicket() {
        purchaseLotteryTicket = new ArrayList<>();
    }

    public void add(LotteryNumbers lotteryNumbers) {
        this.purchaseLotteryTicket.add(lotteryNumbers);
    }

    public LotteryNumbers get(int i) {
        return purchaseLotteryTicket.get(i);
    }

    public LotteryResult countMatchInAllTicket(WinningNumber winningNumber) {
        Map<Rank, Integer> result = new HashMap<>();
        for (LotteryNumbers lotteryNumbers : purchaseLotteryTicket) {
            Rank rank = Rank.valueOf(winningNumber.countMatch(lotteryNumbers), winningNumber.isMatchBonus(lotteryNumbers));
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        }
        return LotteryResult.saveLotteryResult(result);
    }
}
