package lotto;

import lotto.domain.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    private Lotto lotto;

    @BeforeEach
    void setUp() {
        lotto = new Lotto(new int[]{1,2,3,4,5,6});
    }

    @Test
    void 로또_숫자_일치_테스트() {
        assertThat(lotto.isMatch(1));
    }

    @Test
    void 로또_숫자_불일치_테스트() {
        assertThat(lotto.isMatch(7));
    }

    @Test
    void 로또_한개_당첨_테스트() {
        assertThat(lotto.getMatchNumber(new int[] {1,7,8,9,10,11})).isEqualTo(1);
    }

    @Test
    void 로또_여섯개_당첨_테스트() {
        assertThat(lotto.getMatchNumber(new int[] {1,2,3,4,5,6})).isEqualTo(6);
    }

    @Test
    void 로또_0개_당첨_테스트() {
        assertThat(lotto.getMatchNumber(new int[] {7,8,9,10,11,12})).isEqualTo(0);
    }
}
