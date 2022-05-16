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
        LotteryUtils lotteryUtils = new LotteryUtils(Lottery.LOTTERY_MINIMUM_NUMBER, Lottery.LOTTERY_MAXIMUM_NUMBER);
        List<Lottery> lotteries = new LinkedList<>();
        int size = coupon.size();
        while (size-- > 0) {
            lotteries.add(new Lottery(lotteryUtils.pickRandomNumbers(Lottery.LOTTERY_SIZE)));
        }
        return new Lotteries(lotteries);
    }
}
