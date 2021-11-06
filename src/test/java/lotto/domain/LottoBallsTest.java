package lotto.domain;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class LottoBallsTest {

    @DisplayName("6개 미만 공이 주어지면 예외 발생")
    @Test
    void givenLessThanSixBallThenThrowException() {
        List<LottoBall> ballList = Arrays.asList(
                new LottoBall(1), new LottoBall(2), new LottoBall(3)
        );

        ThrowableAssert.ThrowingCallable throwingCallable = () -> new LottoBalls(ballList);

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(throwingCallable)
                .withMessageContaining("로또 공 개수가 6개가 아닙니다");

    }

}