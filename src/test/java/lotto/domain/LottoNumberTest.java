package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.constant.ErrorCode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumberTest {

    @ParameterizedTest
    @CsvSource(value = {"3:3", "45:45", "1:1"}, delimiter = ':')
    void 로또_숫자_1개_생성(int actualNumber, int expectNumber) {
        LottoNumber lottoNumber = new LottoNumber(actualNumber);
        assertThat(lottoNumber).isEqualTo(new LottoNumber(expectNumber));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 46, 0, 47, 123})
    void 로또의_각_숫자는_1이상_45이하가_아니면_에러_발생(int number) {
        assertThatThrownBy(() -> new LottoNumber(number)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.로또의_각_숫자는_1이상_45이하.getErrorMessage());
    }
}
