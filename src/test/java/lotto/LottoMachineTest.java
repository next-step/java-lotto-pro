package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoMachineTest {

    @ParameterizedTest(name = "로또 {0}번을 뽑으면 {0}개의 로또가 반환")
    @ValueSource(ints = {1, 3, 7})
    void repeatLottoNumber(int repeatNumber) {
        LottoMachine lottoMachine = new LottoMachine(repeatNumber);
        assertThat(lottoMachine.getLottoList()).hasSize(repeatNumber);
    }
}
