package lotto;

import org.junit.jupiter.api.Test;

import static lotto.Number.MAX_RANGE_NUMBER;
import static lotto.Number.MIN_RANGE_NUMBER;
import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {

    @Test
    void 로또_자동생성() {
        Lotto lotto = new Lotto(LottoMachine.getRandomNumbers());

        assertThat(lotto.getNumbers()).hasSize(6);
        assertThat(lotto.getNumbers().get(0)).isBetween(MIN_RANGE_NUMBER, MAX_RANGE_NUMBER);
        assertThat(lotto.getNumbers().get(1)).isBetween(MIN_RANGE_NUMBER, MAX_RANGE_NUMBER);
        assertThat(lotto.getNumbers().get(2)).isBetween(MIN_RANGE_NUMBER, MAX_RANGE_NUMBER);
        assertThat(lotto.getNumbers().get(3)).isBetween(MIN_RANGE_NUMBER, MAX_RANGE_NUMBER);
        assertThat(lotto.getNumbers().get(4)).isBetween(MIN_RANGE_NUMBER, MAX_RANGE_NUMBER);
        assertThat(lotto.getNumbers().get(5)).isBetween(MIN_RANGE_NUMBER, MAX_RANGE_NUMBER);
    }

}