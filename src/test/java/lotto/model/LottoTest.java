package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class LottoTest {

    @Test
    void creator() {
        Lotto lotto = new Lotto();
        assertEquals(6, lotto.getNumbers().size());
        assertThat(lotto.getNumbers().get(0)).isBetween(1, 45);
        assertThat(lotto.getNumbers().get(1)).isBetween(1, 45);
        assertThat(lotto.getNumbers().get(2)).isBetween(1, 45);
        assertThat(lotto.getNumbers().get(3)).isBetween(1, 45);
        assertThat(lotto.getNumbers().get(4)).isBetween(1, 45);
        assertThat(lotto.getNumbers().get(5)).isBetween(1, 45);
    }


}