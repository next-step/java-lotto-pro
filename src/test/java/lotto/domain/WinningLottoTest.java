package lotto.domain;

import org.junit.jupiter.api.Test;

import static lotto.domain.LottoTest.로또;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class WinningLottoTest {

    private static final WinningLotto 당첨_로또 = new WinningLotto("1,2,3,4,5,7", 6);

    @Test
    void 당첨로또를_생성한다() {
        assertThat(당첨_로또).isEqualTo(당첨_로또);
    }

    @Test
    void 당첨번호_개수를_반환한다() {
        assertThat(당첨_로또.match(로또)).isEqualTo(Rank.SECOND);
    }

    @Test
    void 당첨번호와_보너스는_중복되지_않는다() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new WinningLotto("1,2,3,4,5,6", 6));
    }
}