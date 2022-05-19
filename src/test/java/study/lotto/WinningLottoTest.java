package study.lotto;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.lotto.enumtype.LottoRank;

class WinningLottoTest extends LottoCommonTest {
    @Test
    @DisplayName("당첨번호 생성")
    void createWinningLotto() {
        Lotto lotto = newLotto("1, 2, 3, 4, 5, 6");
        LottoNumber lottoNumber = new LottoNumber(8);

        assertThatCode(() -> new WinningLotto(lotto, lottoNumber))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("당첨번호 생성 실패 - 보너스번호 중복")
    void createWinningLotto_보너스번호_중복() {
        Lotto lotto = newLotto("1, 2, 3, 4, 5, 6");
        LottoNumber lottoNumber = new LottoNumber(1);

        assertThatThrownBy(() -> new WinningLotto(lotto, lottoNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨번호 확인 - 1등")
    void matchLotto_1st() {
        WinningLotto winningLotto = new WinningLotto(
                newLotto("1, 2, 3, 4, 5, 6"),
                new LottoNumber(7)
        );
        Lotto lotto = newLotto("1, 2, 3, 4, 5, 6");
        Assertions.assertThat(winningLotto.matchLotto(lotto)).isEqualTo(LottoRank.FIRST);
    }

    @Test
    @DisplayName("당첨번호 확인 - 2등")
    void matchLotto_2nd() {
        WinningLotto winningLotto = new WinningLotto(
                newLotto("1, 2, 3, 4, 5, 6"),
                new LottoNumber(7)
        );
        Lotto lotto = newLotto("1, 2, 3, 4, 5, 7");
        Assertions.assertThat(winningLotto.matchLotto(lotto)).isEqualTo(LottoRank.SECOND);
    }

    @Test
    @DisplayName("당첨번호 확인 - 3등")
    void matchLotto_3nd() {
        WinningLotto winningLotto = new WinningLotto(
                newLotto("1, 2, 3, 4, 5, 6"),
                new LottoNumber(7)
        );
        Lotto lotto = newLotto("1, 2, 3, 4, 5, 8");
        Assertions.assertThat(winningLotto.matchLotto(lotto)).isEqualTo(LottoRank.THIRD);
    }
}
