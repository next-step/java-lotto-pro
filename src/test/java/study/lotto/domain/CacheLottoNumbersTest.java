package study.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import study.lotto.domain.number.CacheLottoNumbers;
import study.message.LottoExceptionCode;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("로또 숫자 클래스 테스트")
class CacheLottoNumbersTest {

    @ParameterizedTest
    @ValueSource(ints = { -1, -2, 46, 47, 100 })
    void 로또_숫자_범위가_아니면_IllegalArgumentException_발생(int num) {
        assertThatThrownBy(() -> {
            CacheLottoNumbers.of(num);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoExceptionCode.INVALID_LOTTO_NUMBER.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 11, 22, 33, 45})
    void 로또_숫자_범위_내에서_같은_인스턴스를_반환(int num) {
        assertEquals(CacheLottoNumbers.of(num), CacheLottoNumbers.of(num));
    }

    @ParameterizedTest
    @ValueSource(strings = { "-1", "-2", "-", "88" })
    void 로또_숫자_범위가_아니거나_숫자로_변경할_수_없으면_IllegalArgumentException_발생(String strNumber) {
        assertThatThrownBy(() -> {
            CacheLottoNumbers.ofString(strNumber);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoExceptionCode.INVALID_LOTTO_NUMBER.getMessage());
    }
}
