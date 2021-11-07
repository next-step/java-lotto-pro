package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import lotto.exception.LottoException;

public class LottoNumberTest {

    @DisplayName("로또 숫자 생성 성공")
    @ParameterizedTest
    @ValueSource(ints = {1, 45})
    public void constructLottoNumber_success(int number) {
        assertThat(new LottoNumber(number)).isEqualTo(new LottoNumber(number));
    }

    @DisplayName("로또 숫자 생성 에러")
    @ParameterizedTest
    @ValueSource(ints = {0, 46, -1})
    public void throwsError_whenInvalidLottoNumber(int number) {
        assertThatExceptionOfType(LottoException.class)
            .isThrownBy(() -> new LottoNumber(number))
            .withMessage("1 ~ 45 사이의 숫자를 입력해주세요.");
    }
}
