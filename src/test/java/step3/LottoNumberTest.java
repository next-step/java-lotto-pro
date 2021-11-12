package step3;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import step3.domain.LottoNumber;
import step3.common.exception.InvalidParamException;
import step3.domain.constance.LottoConstant;

public class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46, 100})
    @DisplayName("LottoNumber 는 벗어난 범위의 숫자 생성시 실패 테스트")
    void lottoNumberOverRangeFail(int inputLottoNumber) {
        assertThatExceptionOfType(InvalidParamException.class)
            .isThrownBy(() -> {
                // when
                LottoNumber.of(inputLottoNumber);
            });
    }
}
