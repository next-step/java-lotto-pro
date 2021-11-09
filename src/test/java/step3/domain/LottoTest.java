package step3.domain;

import static helper.Constants.*;
import static org.assertj.core.api.Assertions.*;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("로또 테스트")
class LottoTest {

    @ParameterizedTest(name = DISPLAY_NAME)
    @CsvSource(value = "3,2,42,12,40,11")
    void _6개의_숫자를_조합해_로또를_만들_수_있다(final int one, final int two, final int three,
        final int four, final int five, final int six) {
        //given
        final List<LottoNumber> lottoNumbers = Arrays.asList(
            new LottoNumber(one), new LottoNumber(two), new LottoNumber(three),
            new LottoNumber(four), new LottoNumber(five), new LottoNumber(six)
        );

        //when
        final Lotto lotto = new Lotto(lottoNumbers);

        //then
        assertThat(lotto).isNotNull().isEqualTo(new Lotto(lottoNumbers));
    }

    @ParameterizedTest(name = DISPLAY_NAME)
    @CsvSource(value = "3,2,42,12,40,11,7")
    void _6개의_숫자이상으로_조합해_로또를_만드려고_하면_예외가발생한다(final int one, final int two, final int three,
        final int four, final int five, final int six, final int seven) {
        //given
        final List<LottoNumber> lottoNumbers = Arrays.asList(
            new LottoNumber(one), new LottoNumber(two), new LottoNumber(three),
            new LottoNumber(four), new LottoNumber(five), new LottoNumber(six), new LottoNumber(seven)
        );

        //when
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(lottoNumbers));
    }
}