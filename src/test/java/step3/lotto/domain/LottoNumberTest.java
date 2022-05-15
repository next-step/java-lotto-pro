package step3.lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static step3.lotto.domain.LottoNumber.INVALID_LOTTO_NUMBER_RANGE_ERROR;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * @author : choi-ys
 * @date : 2022/05/15 9:19 오후
 */
@DisplayName("Domain:LottoNumber")
class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 45})
    @DisplayName("1~45 범위를 보장하는 로또 번호 객체 생성")
    public void createLottoNumberTest(final int given) {
        // When & Then
        assertThat(LottoNumber.of(given).getLottoNumber()).isEqualTo(given);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    @DisplayName("1~45 범위를 벗어나는 로또 번호 객체 생성 시 예외")
    public void throwException_WhenGivenNumberIsInvalidRange(final int given) {
        // When & Then
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> LottoNumber.of(given))
            .withMessageMatching(INVALID_LOTTO_NUMBER_RANGE_ERROR);
    }
}
