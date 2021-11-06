package lotto.domain;

import java.util.List;

public class LottoBalls {
    private List<LottoBall> lottoBalls;

    public LottoBalls(List<LottoBall> lottoBalls) {
        if (lottoBalls.size() != LottoBallEnum.LOTTO_BALLS_SIZE.getNumber()) {
            throw new IllegalArgumentException("로또 공 개수가 6개가 아닙니다");
        }
        this.lottoBalls = lottoBalls;
    }
}