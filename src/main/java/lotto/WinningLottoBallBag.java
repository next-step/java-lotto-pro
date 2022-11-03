package lotto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WinningLottoBallBag {

    public static final String WINNING_NUMBER_INPUT_SPLIT_DELIMITER = ", |,";

    private static final int WINNING_BALL_SIZE = 6;
    private static final int CONTAINS_BONUS_BALL_SIZE = 7;
    private final List<LottoBall> lottoBalls;

    public WinningLottoBallBag(String lottoNumbers) {
        this.lottoBalls = Arrays.stream(lottoNumbers.split(WINNING_NUMBER_INPUT_SPLIT_DELIMITER))
                .map(LottoBall::fromStringNormal)
                .collect(Collectors.toList());
        shouldLessThanSize(WINNING_BALL_SIZE);
        validUnique();
    }

    public void add(LottoBall lottoBall) {
        shouldLessThanSize(CONTAINS_BONUS_BALL_SIZE);
        validUnique(lottoBall);
        lottoBalls.add(lottoBall);
    }

    private void validUnique() {
        if (lottoBalls.stream().distinct().count() != lottoBalls.size()) {
            throw new IllegalArgumentException(
                    "로또 숫자는 중복되지 않은 값이어야 합니다. 입력 값:" + lottoBalls.stream()
                            .map(String::valueOf)
                            .collect(Collectors.joining(",")));
        }
    }

    private void validUnique(LottoBall lottoBall) {
        Set<LottoBall> lottoBallSet = new HashSet<>(lottoBalls);
        if (lottoBallSet.contains(lottoBall)) {
            throw new IllegalArgumentException(
                    "로또 숫자는 중복되지 않은 값이어야 합니다. 입력 값:" + lottoBall.getIntNumber());
        }
    }

    private void shouldLessThanSize(int ballSize) {
        if (lottoBalls.size() > ballSize) {
            throw new IllegalStateException("로또 숫자 갯수는 " + ballSize + "개 미만이어야 합니다");
        }
    }

    public Score matchScore(List<Number> lottoNumbers) {
        return Score.of(lottoBalls.stream()
                .filter(lottoBall -> lottoNumbers.contains(lottoBall.getLottoNumber()))
                .mapToDouble(LottoBall::getScore)
                .sum());
    }
}
