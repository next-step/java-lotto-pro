package step3.domain;

import static helper.Constants.*;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step3.domain.Lotto;
import step3.domain.LottoNumber;

@DisplayName("로또 테스트")
class LottoTest {

    @ParameterizedTest(name = DISPLAY_NAME)
    @CsvSource(value = "3,2,42,12,40,11")
    void _6개의_숫자를_조합해_로또_티켓하나를_만들_수_있다(final int one, final int two, final int three,
        final int four, final int five, final int six) {
        //given
        final LottoNumber[] lottoNumbers = {
            new LottoNumber(one), new LottoNumber(two), new LottoNumber(three),
            new LottoNumber(four), new LottoNumber(five), new LottoNumber(six)
        };

        //when
        final Lotto lotto = new Lotto(lottoNumbers);

        //then
        assertThat(lotto).isNotNull().isEqualTo(new Lotto(lottoNumbers));
    }
}