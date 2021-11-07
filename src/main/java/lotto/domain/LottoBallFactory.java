package lotto.domain;

import lotto.exception.CreateLottoBallFactoryException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoBallFactory {
    private static final List<LottoBall> CACHE_BALL = new ArrayList<>();

    static {
        for (int i = LottoBallRule.MIN_LOTTO_NUMBER.getNumber(); i <= LottoBallRule.MAX_LOTTO_NUMBER.getNumber(); i++) {
            CACHE_BALL.add(new LottoBall(i));
        }
    }

    private LottoBallFactory() {
        throw new CreateLottoBallFactoryException("LottoBallFactory 생성자는 호출되면 안됩니다.");
    }

    public static List<LottoBall> draw() {
        Collections.shuffle(CACHE_BALL);
        List<LottoBall> ballsDraw = new ArrayList<>(CACHE_BALL.subList(0, LottoBallRule.LOTTO_BALLS_SIZE.getNumber()));
        Collections.sort(ballsDraw);
        return ballsDraw;
    }
}
