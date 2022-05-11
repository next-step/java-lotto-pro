package step3;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PayTest {
    @Test
    void 구매할_수_있는_로또_개수_확인() {
        assertThat(Pay.ableToBuyLottoCount(1000)).isEqualTo(1);
        assertThat(Pay.ableToBuyLottoCount(5000)).isEqualTo(5);
        assertThat(Pay.ableToBuyLottoCount(100)).isEqualTo(0);
    }
}