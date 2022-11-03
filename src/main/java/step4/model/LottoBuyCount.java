package step4.model;

import step4.constant.ErrorMessageConstant;
import step4.constant.LottoConstant;
import step4.exception.LottoFormatException;

import java.util.Objects;

public class LottoBuyCount {

    private int lottoBuyCount;
    private static final Money ONE_GAME_MONEY = new Money(LottoConstant.LOTTO_ONE_GAME_MONEY);
    public LottoBuyCount(Money money) {
        if (money.isLessThan(ONE_GAME_MONEY)) {
            throw new LottoFormatException(ErrorMessageConstant.ZERO_LOTTO_BUY_COUNT);
        }
        this.lottoBuyCount = money.divideValue(ONE_GAME_MONEY);
    }

    public LottoBuyCount(int count) {
        if (count < 0) {
            throw new LottoFormatException(ErrorMessageConstant.NEGATIVE_NUMBER);
        }
        this.lottoBuyCount = count;
    }

    public LottoBuyCount(String count) {
        this(convertNumber(count));
    }

    private static int convertNumber(String text) {
        int result;
        try {
            result = Integer.parseInt(text);
        } catch (NumberFormatException e) {
            throw new LottoFormatException(ErrorMessageConstant.NOT_NUMBER);
        }
        return result;
    }

    public void plus() {
        this.lottoBuyCount++;
    }

    public LottoBuyCount minus(LottoBuyCount otherLottoBuyCount) {
        return new LottoBuyCount(this.lottoBuyCount - otherLottoBuyCount.lottoBuyCount);
    }

    public boolean isEqualValue(int count) {
        return this.lottoBuyCount == count;
    }

    public boolean isLessThan(LottoBuyCount otherLottoBuyCount) {
        return this.lottoBuyCount < otherLottoBuyCount.lottoBuyCount;
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
