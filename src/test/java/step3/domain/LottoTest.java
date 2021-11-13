package step3.domain;

import static org.assertj.core.api.Assertions.*;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("로또 테스트")
class LottoTest {

    @Test
    void _6개의_숫자를_조합해_로또를_만들_수_있다() {
        //given
        final List<LottoNumber> lottoNumbers = Arrays.asList(
            new LottoNumber(3), new LottoNumber(2), new LottoNumber(42),
            new LottoNumber(12), new LottoNumber(40), new LottoNumber(11)
        );

        //when
        final Lotto lotto = new Lotto(lottoNumbers);

        //then
        assertThat(lotto).isNotNull().isEqualTo(new Lotto(lottoNumbers));
    }

    @Test
    void _6개의_숫자이상으로_조합해_로또를_만드려고_하면_예외가발생한다() {
        //given
        final List<LottoNumber> lottoNumbers = Arrays.asList(
            new LottoNumber(3), new LottoNumber(2), new LottoNumber(42),
            new LottoNumber(12), new LottoNumber(40), new LottoNumber(11)
        );

        //when
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(lottoNumbers));
    }
}