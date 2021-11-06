package step3;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import step3.domain.LottoNumber;
import step3.common.exception.InvalidParamException;
import step3.domain.constance.LottoConstant;

public class LottoNumberTest {

    @Test
    @DisplayName("LottoNumber 객체를 생성하고 동등성 비교합니다.")
    void lottoNumberCreate() {
        int number = 10;
        LottoNumber lottoNumber = new LottoNumber(number);

        assertThat(lottoNumber).isEqualTo(new LottoNumber(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46, 100})
    @DisplayName("LottoNumber 는 벗어난 범위의 숫자 생성시 실패 테스트")
    void lottoNumberOverRangeFail(int inputLottoNumber) {
        assertThatExceptionOfType(InvalidParamException.class)
            .isThrownBy(() -> {
                // when
                new LottoNumber(inputLottoNumber);
            }) // then
            .withMessageMatching(LottoConstant.LOTTO_RANGE_OVER_EXCEPTION);
    }
}
