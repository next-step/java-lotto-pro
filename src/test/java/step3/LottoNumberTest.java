package step3;

import static helper.Constants.*;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("로또번호 테스트")
class LottoNumberTest {

    @ParameterizedTest(name = DISPLAY_NAME)
    @CsvSource(value = "1,45")
    void _1에서_45번으로_로또번호를_만들_수_있다(final int startNumber, final int endNumber) {
        for (int lottoNumber = startNumber; lottoNumber <= endNumber; lottoNumber++) {
            //given when
            final LottoNumber lotto = new LottoNumber(lottoNumber);

            //then
            assertThat(lotto).isNotNull().isEqualTo(new LottoNumber(lottoNumber));
        }
    }
}
