package step3.domain;

import static helper.Constants.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("로또번호 테스트")
class LottoNumberTest {

    @Test
    void _1에서_45번으로_로또번호를_만들_수_있다() {
        final int startNumber = 1;
        final int endNumber = 45;

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

    @Test
    void 당첨_로또번호와_비교해서_맞은_숫자개수를_얻을_수_있다() {
        //given
        final List<LottoNumber> winningLottoNumbers = Collections.singletonList(new LottoNumber(7));

        final LottoNumber sameLottoNumber = new LottoNumber(7);
        final LottoNumber notSameLottoNumber = new LottoNumber(3);

        //when
        final int sameLottoNumberWinningCount = sameLottoNumber.findWinningCount(winningLottoNumbers);
        final int notSameLottoNumberWinningCount = notSameLottoNumber.findWinningCount(winningLottoNumbers);

        //then
        assertAll(
            () -> assertThat(sameLottoNumberWinningCount).isEqualTo(1),
            () -> assertThat(notSameLottoNumberWinningCount).isEqualTo(0)
        );
    }
}
