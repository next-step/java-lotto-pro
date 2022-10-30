package step3.model;

import step3.constant.ErrorMessageConstant;
import step3.constant.LottoConstant;

import java.util.Objects;

public class LottoBuyCount {

    private int lottoBuyCount;

    public LottoBuyCount(Money money) {
        Money oneGameMoney = new Money(LottoConstant.LOTTO_ONE_GAME_MONEY);
        if (money.isLessThan(oneGameMoney)) {
            throw new RuntimeException(ErrorMessageConstant.ZERO_LOTTO_BUY_COUNT);
        }
        this.lottoBuyCount = money.divide(oneGameMoney);
    }

    public LottoBuyCount(int count) {
        if (count < 0) {
            throw new RuntimeException(ErrorMessageConstant.NEGATIVE_NUMBER);
        }
        this.lottoBuyCount = count;
    }

    public void plus() {
        this.lottoBuyCount++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoBuyCount that = (LottoBuyCount) o;
        return lottoBuyCount == that.lottoBuyCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoBuyCount);
    }

    @Override
    public String toString() {
        return lottoBuyCount + "";
    }
}
