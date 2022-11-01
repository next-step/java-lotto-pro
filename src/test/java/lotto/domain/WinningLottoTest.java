package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import common.constant.ErrorCode;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {

    @Test
    void 구매_로또와_당첨_로또간_매치_개수_확인() {
        Lotto lotto1 = Lotto.generateLotto(new ReadLineLottoNumberGenerator("1, 2, 3, 4, 5, 6"));
        Lotto lotto2 = Lotto.generateLotto(new ReadLineLottoNumberGenerator("1, 2, 3, 4, 5, 16"));
        WinningLotto winningLotto = new WinningLotto(Lotto.generateLotto(new ReadLineLottoNumberGenerator("1, 2, 3, 4, 5, 6")), LottoNumber.from(8));
        assertThat(winningLotto.findLottoMatchCount(lotto1)).isEqualTo(6);
        assertThat(winningLotto.findLottoMatchCount(lotto2)).isEqualTo(5);
    }

    @Test
    void 당첨_로또와_보너스볼이_중복되면_에러_발생() {
        assertThatThrownBy(() -> new WinningLotto(Lotto.generateLotto(new ReadLineLottoNumberGenerator("1, 2, 3, 4, 5, 6")), LottoNumber.from(5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.보너스_볼은_당첨_로또의_각_숫자와_중복_불가.getErrorMessage());
    }

    @Test
    void 구매_로또와_보너스볼_간_매치할_경우_true() {
        Lotto lotto = Lotto.generateLotto(new ReadLineLottoNumberGenerator("1, 2, 3, 4, 5, 16"));
        WinningLotto winningLotto = new WinningLotto(Lotto.generateLotto(new ReadLineLottoNumberGenerator("1, 2, 4, 5, 6, 18")), LottoNumber.from(3));
        assertThat(winningLotto.isMatchBonusLottoNumber(lotto)).isTrue();
    }
}
