package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LottoMachineTest {

    @Test
    void 로또_자동생성() {
        Lotto lotto = new Lotto(LottoMachine.getRandomNumbers());

        assertThat(lotto.getNumbers()).hasSize(6);
    }

}