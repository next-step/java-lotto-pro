package lotto.domain;

import lotto.exception.LottoBallCountException;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LottoBallsTest {

    @DisplayName("6개 미만 공이 주어지면 예외 발생")
    @Test
    void givenLessThanSixBallThenThrowException() {
        List<LottoBall> ballList = Arrays.asList(
                new LottoBall(1), new LottoBall(2), new LottoBall(3)
        );

        ThrowableAssert.ThrowingCallable throwingCallable = () -> new LottoBalls(ballList);

        assertThatExceptionOfType(LottoBallCountException.class)
                .isThrownBy(throwingCallable)
                .withMessageContaining("로또 공 개수가 6개가 아닙니다");

    }

    @DisplayName("당첨번호와 일치하는 번호의 개수를 구한다")
    @Test
    void countWinningBallCount() {
        LottoBalls balls = new LottoBalls(Arrays.asList(
                new LottoBall(1), new LottoBall(2), new LottoBall(3),
                new LottoBall(4), new LottoBall(5), new LottoBall(6)
        ));

        LottoBalls winningBalls = new LottoBalls(Arrays.asList(
                new LottoBall(1), new LottoBall(2), new LottoBall(3),
                new LottoBall(7), new LottoBall(8), new LottoBall(9)
        ));

        int result = balls.countContainingWinNumbers(winningBalls);

        assertThat(result).isEqualTo(3);
    }

    @DisplayName("보너스볼을 가지고 있으면 true 반환")
    @Test
    void hasBonusBall() {
        LottoBalls balls = new LottoBalls(Arrays.asList(
                new LottoBall(1), new LottoBall(2), new LottoBall(3),
                new LottoBall(4), new LottoBall(5), new LottoBall(6)
        ));
        LottoBall bonusBall = new LottoBall(5);

        assertThat(balls.hasBonusBall(bonusBall)).isTrue();
    }

}
