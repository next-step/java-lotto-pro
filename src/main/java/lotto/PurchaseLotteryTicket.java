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
        for (LotteryNumbers userLottoNumbers : purchaseLotteryTicket) {
            Rank rank = winningNumber.match(userLottoNumbers);
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        }
        return LotteryResult.saveLotteryResult(result);
    }
}
