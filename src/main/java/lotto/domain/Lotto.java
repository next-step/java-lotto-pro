package lotto.domain;

import lotto.exception.MyErrorCode;
import lotto.exception.MyException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private static final int LOTTO_COUNT_VALID_SIZE = 6;
    private List<Ball> balls;

    public Lotto(List<Ball> balls) {
        checkDuplicationBall(balls);
        checkLengthOverThanSix(balls);
        this.balls = balls;
    }

    public List<Ball> balls() {
        return this.balls;
    }

    public List<Integer> extractNumber(){
        List<Integer> numbers = new ArrayList<>();
        for (Ball ball : balls) {
            numbers.add(ball.number());
        }
        return numbers;
    }

    private List<Ball> makeBalls(List<Integer> ballNumbers) {
        return ballNumbers.stream()
                .map(number -> new Ball(number))
                .collect(Collectors.toList());
    }

    private void checkLengthOverThanSix(List<Ball> balls) {
        int ballsSize = balls.size();
        if (!isValidInputLottoRange(ballsSize)) {
            throw new MyException(MyErrorCode.VALID_LOTTO_SIZE_SIX);
        }
    }

    private boolean isValidInputLottoRange(int ballsSize) {
        return ballsSize == LOTTO_COUNT_VALID_SIZE;
    }

    private void checkDuplicationBall(List<Ball> balls) {
        Set<Ball> notDuplicationBalls = new HashSet<>();
        for (Ball ball : balls) {
            notDuplicationBalls.add(ball);
        }
        if (balls.size() != notDuplicationBalls.size()) {
            throw new MyException(MyErrorCode.EXIST_DUPLICATION_NUMBER);
        }
    }
}
