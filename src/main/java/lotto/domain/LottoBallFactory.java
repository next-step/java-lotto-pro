package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoBallFactory {
    private static final List<LottoBall> CAHCE_BALL = new ArrayList<>();

    static {
        for (int i = LottoBallRule.MIN_LOTTO_NUMBER.getNumber(); i <= LottoBallRule.MAX_LOTTO_NUMBER.getNumber(); i++) {
            CAHCE_BALL.add(new LottoBall(i));
        }
    }

    public static List<LottoBall> draw() {
        Collections.shuffle(CAHCE_BALL);
        List<LottoBall> ballsDraw = new ArrayList<>(CAHCE_BALL.subList(0, LottoBallRule.LOTTO_BALLS_SIZE.getNumber()));
        Collections.sort(ballsDraw);
        return ballsDraw;
    }
}