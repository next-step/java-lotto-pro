package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import lotto.exception.LottoException;

public class BallTest {

    @DisplayName("로또 숫자 생성 성공")
    @ParameterizedTest
    @ValueSource(ints = {1, 45})
    public void constructBall_success(int number) {
        assertThat(new Ball(number)).isEqualTo(new Ball(number));
    }

    @DisplayName("로또 숫자 생성 에러")
    @ParameterizedTest
    @ValueSource(ints = {0, 46, -1})
    public void throwsError_whenInvalidBall(int number) {
        assertThatExceptionOfType(LottoException.class)
            .isThrownBy(() -> new Ball(number))
            .withMessage("1 ~ 45 사이의 숫자를 입력해주세요.");
    }
}
