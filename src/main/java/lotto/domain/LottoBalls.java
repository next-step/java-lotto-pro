package lotto.domain;

import lotto.exception.LottoBallCountException;

import java.util.Collections;
import java.util.List;

public class LottoBalls {
    private List<LottoBall> lottoBalls;

    public LottoBalls(List<LottoBall> lottoBalls) {
        if (lottoBalls.size() != LottoBallRule.LOTTO_BALLS_SIZE.getNumber()) {
            throw new LottoBallCountException("로또 공 개수가 6개가 아닙니다");
        }
        this.lottoBalls = Collections.unmodifiableList(lottoBalls);
    }

    public List<LottoBall> getLottoBalls() {
        return Collections.unmodifiableList(lottoBalls);
    }

    public int countContainingWinNumbers(LottoBalls winLottoBalls) {
        int count = 0;
        for (LottoBall winBall : winLottoBalls.lottoBalls) {
            count = lottoBalls.contains(winBall) ? count + 1 : count;
        }
        return count;
    }

    public boolean hasBonusBall(LottoBall bonusBall) {
        return lottoBalls.contains(bonusBall);
    }
}
