package lotto.domain;

import lotto.domain.error.LottoNumberErrorCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {

    @ParameterizedTest(name = "String lottoNumber가 null 또는 empty일 때")
    @NullAndEmptySource
    public void String_생성자_테스트_null_or_empty(String lottoNumber) throws Exception {
        assertThatThrownBy(() -> new LottoNumber(lottoNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoNumberErrorCode.NOT_ALLOW_NULL.getMessage());
    }

    @ParameterizedTest(name = "String lottoNumber가 로또 번호가 아닐 때")
    @ValueSource(strings = {"0", "46"})
    public void String_생성자_테스트(String lottoNumber) throws Exception {
        assertThatThrownBy(() -> new LottoNumber(lottoNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(
                        String.format(LottoNumberErrorCode.INVALID_LOTTO_NUMBER.getMessage(),
                                LottoNumber.MIN, LottoNumber.MAX));
    }

    @ParameterizedTest(name = "int lottoNumber가 로또 번호가 아닐 때")
    @ValueSource(ints = {0, 46})
    public void int_생성자_테스트(int lottoNumber) {
        assertThatThrownBy(() -> new LottoNumber(lottoNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(
                        String.format(LottoNumberErrorCode.INVALID_LOTTO_NUMBER.getMessage(),
                                LottoNumber.MIN, LottoNumber.MAX));
    }

    @Test
    @DisplayName("LottoNumber 동등성")
    public void equals_identity_test() {
        LottoNumber lottoNumber = new LottoNumber(1);

        assertThat(lottoNumber).isEqualTo(new LottoNumber(1));
    }
}