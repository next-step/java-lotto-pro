package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import lotto.enums.LottoRank;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

    @Test
    void 보너스볼이_로또번호에_포함되어서는_안된다() {
        assertThatThrownBy(() ->
                WinningLotto.of(LottoNumbers.from(Arrays.asList(1, 2, 3, 4, 5, 6)), LottoNumber.from(6))
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void match_test() {
        WinningLotto winningLotto = WinningLotto.of(LottoNumbers.from(Arrays.asList(1, 2, 3, 4, 5, 6)), LottoNumber.from(7));
        LottoNumbers lottoNumbers = LottoNumbers.from(Arrays.asList(1, 2, 3, 4, 5, 7));
        LottoRank rank = winningLotto.match(lottoNumbers);
        assertThat(rank).isEqualTo(LottoRank.SECOND);
    }
}
