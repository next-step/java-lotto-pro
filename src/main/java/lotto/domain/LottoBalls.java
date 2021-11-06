package lotto.domain;

import java.util.List;

public class LottoBalls {
    private static final int BALLS_SIZE = 6;
    private List<LottoBall> lottoBalls;

    public LottoBalls(List<LottoBall> lottoBalls) {
        if (lottoBalls.size() != BALLS_SIZE) {
            throw new IllegalArgumentException("로또 공 개수가 6개가 아닙니다");
        }
        this.lottoBalls = lottoBalls;
    }
}