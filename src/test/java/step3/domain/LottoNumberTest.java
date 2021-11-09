package step3.domain;

import static helper.Constants.*;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("로또번호 테스트")
class LottoNumberTest {

    @ParameterizedTest(name = DISPLAY_NAME)
    @CsvSource(value = "1,45")
    void _1에서_45번으로_로또번호를_만들_수_있다(final int startNumber, final int endNumber) {
        for (int number = startNumber; number <= endNumber; number++) {
            //given when
            final LottoNumber lottoNumber = new LottoNumber(number);

            //then
            assertThat(lottoNumber).isNotNull().isEqualTo(new LottoNumber(number));
        }
    }

    @Test
    void 음수로_로또번호를_만드려고_하면_예외가발생한다() {
        //given
        final int number = -1;

        //when then
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(number)).withMessageContaining("음수");
    }

    @ParameterizedTest(name = DISPLAY_NAME)
    @ValueSource(ints = {0, 46, 57, 100})
    void _1에서_45번_이외의_숫자로_로또번호를_만드려고_하면_예외가발생한다(final int number) {
        //when then
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(number));
    }
}
