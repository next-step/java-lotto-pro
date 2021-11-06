package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoBallFactory {
    private static final int MIN = 1;
    private static final int MAX = 45;
    private static final int BALLS_SIZE = 6;
    private static final List<LottoBall> CAHCE_BALL = new ArrayList<>();

    static {
        for (int i = MIN; i <= MAX; i++) {
            CAHCE_BALL.add(new LottoBall(i));
        }
    }

    public static List<LottoBall> draw() {
        Collections.shuffle(CAHCE_BALL);
        List<LottoBall> ballsDraw = new ArrayList<>(CAHCE_BALL.subList(0, BALLS_SIZE));
        Collections.sort(ballsDraw);
        return ballsDraw;
    }
}
