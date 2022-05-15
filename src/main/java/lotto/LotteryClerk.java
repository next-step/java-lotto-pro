package lotto;

import lotto.vo.Coupon;
import lotto.vo.Money;

public class LotteryClerk {
    private LotteryClerk() {
    }

    public static Coupon exchangeCoupon(Money money) {
        return new Coupon(money);
    }
}
