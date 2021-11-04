package lotto.domain;

import lotto.exception.InputDataErrorCode;
import lotto.exception.InputDataException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class BallTest {
    @Test
    @DisplayName("1~45사이의 로또 볼을 생성한다.")
    void createLottoBallTest() {
        Ball ball = new Ball(1);
        Assertions.assertThat(ball.number()).isEqualTo(1);
    }

    @Test
    @DisplayName("1~45 범위 밖의 로또 볼을 생성한다.")
    void createOverRangeLottoBallTest() {
        assertThatExceptionOfType(InputDataException.class)
                .isThrownBy(() -> {
                    new Ball(0);
                }).withMessageContaining(InputDataErrorCode.INVALID_RANGE_LOTTO_NUMBER.errorMessage());
    }

}
