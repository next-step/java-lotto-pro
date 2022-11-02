package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {

    @Test
    @DisplayName("machine은 입력된 갯수만큼 lotto를 생성함")
    void test2() {
        LottoMachine machine = new LottoMachine();
        List<Lotto> lottoTickets = machine.getNewMultiLottoList(7);

        assertThat(lottoTickets.size()).isEqualTo(7);
    }
}