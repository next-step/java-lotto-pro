package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.ThrowableAssert.ThrowingCallable;

public class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 45})
    @DisplayName("로또번호가 유효한 번호일 경우")
    public void 로또번호가_1과_45_사이이다(int input) {
        LottoNumber lottoNumber = LottoNumber.from(input);
        assertThat(lottoNumber).isEqualTo(LottoNumber.from(input));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    @DisplayName("로또번호가 유효한 번호가 아닐 경우")
    public void 로또번호가_1과_45_사이가_아니다(int input) {
        ThrowingCallable throwingCallable = () -> LottoNumber.from(input);

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(throwingCallable);
    }

}
