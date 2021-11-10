package lotto.domain;

import lotto.exception.DuplicateNumberException;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoBallFactoryTest {

    @DisplayName("서로 다른 6개의 공을 생성한다")
    @Test
    void createSixBalls() {
        List<LottoBall> draw = LottoBallFactory.draw();
        assertAll(
                () -> assertThat(draw.size()).isEqualTo(6),
                () -> assertThat(draw).doesNotHaveDuplicates()
        );
    }

    @DisplayName("문자열로 서로 다른 6개의 공을 생성한다")
    @Test
    void createSixBallsByString() {
        List<LottoBall> draw = LottoBallFactory.createLottoBallByStringNumber("1,2,3,4,5,6");
        assertAll(
                () -> assertThat(draw.size()).isEqualTo(6),
                () -> assertThat(draw).doesNotHaveDuplicates()
        );
    }

    @DisplayName("문자열에 중복되는 숫자가 있으면 예외가 발생한다")
    @Test
    void duplicate() {
        ThrowableAssert.ThrowingCallable throwingCallable = () -> LottoBallFactory.createLottoBallByStringNumber("1,2,3,4,6,6");
        assertThatExceptionOfType(DuplicateNumberException.class)
                .isThrownBy(throwingCallable)
                .withMessageContaining("중복된 숫자가 존재합니다.");
    }

}
