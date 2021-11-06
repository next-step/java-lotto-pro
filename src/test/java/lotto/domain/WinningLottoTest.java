package lotto.domain;

import org.junit.jupiter.api.Test;

import static lotto.domain.LottoTest.로또;
import static org.assertj.core.api.Assertions.assertThat;

class WinningLottoTest {

    @Test
    void 당첨로또를_생성한다() {
        assertThat(new WinningLotto("1,2,3,4,5,6", 7)).isEqualTo(new WinningLotto("1,2,3,4,5,6", 7));
    }

    @Test
    void 당첨번호_개수를_반환한다() {
        WinningLotto 당첨_로또 = new WinningLotto("1,2,3,4,5,7", 6);
        assertThat(당첨_로또.match(로또)).isEqualTo(Rank.SECOND_BONUS);
    }
}