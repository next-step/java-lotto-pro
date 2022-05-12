package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMachineTest {

    @Test
    @DisplayName("로또기계에 돈을 넣으면 로또가 생성")
    void getLottoList() {
        LottoMachine lottoMachine = new LottoMachine("1000");

        assertThat(lottoMachine.getLottoNumbers()).isNotNull();
    }
}
