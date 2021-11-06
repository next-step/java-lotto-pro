package study.lotto.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LottoNumberTest {

    @Test
    void 로또번호는_1에서_45_까지의_숫자로_구성되어_있다() {
        assertAll(() -> {
            for (int number = 1; number <= 45; number++) {
                // given
                final LottoNumber lottoNumber = LottoNumber.valueOf(number);
                // when
                final boolean result = lottoNumber.getValue() == number;
                // then
                assertThat(result).isTrue();
            }
        });
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -2, -11, 0, 46, 578, 11233})
    void 로또번호는_1에서_45_까지의_숫자_예외일_경우_생성시_예외객체가_발생한다(final int number) {
        assertThatExceptionOfType(MalFormedLottoNumberException.class)
                .isThrownBy(() -> LottoNumber.valueOf(number))
                .withMessageMatching("로또번호는 1부터 45까지의 숫자로 구성되어야 합니다.");
    }
}
