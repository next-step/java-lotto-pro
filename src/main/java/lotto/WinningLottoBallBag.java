package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLottoBallBag {

    public static final String WINNING_NUMBER_INPUT_SPLIT_DELIMITER = ", |,";

    private static final int WINNING_BALL_SIZE = 6;
    private static final int CONTAINS_BONUS_BALL_SIZE = 7;
    private final List<LottoBall> lottoBalls;

    public WinningLottoBallBag(String lottoNumbers, Score score) {
        this.lottoBalls = Arrays.stream(lottoNumbers.split(WINNING_NUMBER_INPUT_SPLIT_DELIMITER))
                .map(num -> new LottoBall(num, score))
                .collect(Collectors.toList());
        shouldLessThanSize(WINNING_BALL_SIZE);
        validUnique();
    }

    public void add(LottoBall lottoBall) {
        shouldLessThanSize(CONTAINS_BONUS_BALL_SIZE);
        lottoBalls.add(lottoBall);
        validUnique();
    }

    private void validUnique() {
        if (lottoBalls.stream().distinct().count() != lottoBalls.size()) {
            throw new IllegalArgumentException(
                    "로또 숫자는 중복되지 않은 값이어야 합니다. 입력 값:" + lottoBalls.stream()
                            .map(String::valueOf)
                            .collect(Collectors.joining(",")));
        }
    }

    private void shouldLessThanSize(int ballSize) {
        if (lottoBalls.size() > ballSize) {
            throw new IllegalStateException("로또 숫자 갯수는 " + ballSize + "개 미만이어야 합니다");
        }
    }

    public double matchScore(List<Number> lottoNumbers) {
        return lottoBalls.stream()
                .filter(it -> lottoNumbers.stream()
                        .map(Number::getIntNumber)
                        .collect(Collectors.toList())
                        .contains(it.getIntNumber()))
                .mapToDouble(LottoBall::getScore)
                .sum();
    }
}
