package lotto;

import lotto.vo.Coupon;
import lotto.vo.Lotteries;
import lotto.vo.Lottery;

import java.util.LinkedList;
import java.util.List;

public class LotteryStore {
    private LotteryStore() {
    }

    public static Lotteries exchangeCouponToLotteries(Coupon coupon) {
        LotteryUtils lotteryUtils = new LotteryUtils(Lottery.MINIMUM_NUMBER, Lottery.MAXIMUM_NUMBER);
        List<Lottery> lotteries = new LinkedList<>();
        int size = coupon.size();
        while (size-- > 0) {
            lotteries.add(new Lottery(lotteryUtils.pickRandomNumbers(Lottery.SIZE)));
        }
        return new Lotteries(lotteries);
    }
}
