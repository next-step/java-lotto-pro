package lotto.vo;

import java.util.Objects;

public class Coupon {
    private static final int LOTTERY_PURCHASE_UNIT = 1000;
    private static final String LOTTERY_MINIMUM_PURCHASE_AMOUNT_IS_1000_WON = "로또 구입 금액은 최소 1,000원 입니다.";
    private static final String LOTTERY_PURCHASE_AMOUNT_IS_IN_UNITS_OF_1000_WON = "로또 구입 금액은 1,000원 단위입니다.";

    private int coupons;

    public Coupon(Money money) {
        if (money.value() < LOTTERY_PURCHASE_UNIT) {
            throw new IllegalArgumentException(LOTTERY_MINIMUM_PURCHASE_AMOUNT_IS_1000_WON);
        }
        if (money.value() % LOTTERY_PURCHASE_UNIT > 0) {
            throw new IllegalArgumentException(LOTTERY_PURCHASE_AMOUNT_IS_IN_UNITS_OF_1000_WON);
        }
        this.coupons = money.value() / LOTTERY_PURCHASE_UNIT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coupon coupon = (Coupon) o;
        return coupons == coupon.coupons;
    }

    @Override
    public int hashCode() {
        return Objects.hash(coupons);
    }

    @Override
    public String toString() {
        return "Coupon{" +
                "coupons=" + coupons +
                '}';
    }
}
