package step4.model;

import step4.constant.ErrorMessageConstant;
import step4.constant.LottoConstant;
import step4.exception.LottoFormatException;

import java.util.Objects;

public class LottoBuyCount {

    private int lottoBuyCount;
    private final static Money oneGameMoney = new Money(LottoConstant.LOTTO_ONE_GAME_MONEY);
    public LottoBuyCount(Money money) {
        if (money.isLessThan(oneGameMoney)) {
            throw new LottoFormatException(ErrorMessageConstant.ZERO_LOTTO_BUY_COUNT);
        }
        this.lottoBuyCount = money.divideValue(oneGameMoney);
    }

    public LottoBuyCount(int count) {
        if (count < 0) {
            throw new LottoFormatException(ErrorMessageConstant.NEGATIVE_NUMBER);
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
