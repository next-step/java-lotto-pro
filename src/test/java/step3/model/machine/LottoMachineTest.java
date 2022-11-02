package step3.model.machine;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import step3.model.lotto.LottoList;

class LottoMachineTest {
    private final LottoAutoGenerator lottoAutoGenerator = new ShuffleLottoGenerator();
    private final LottoMachine lottoMachine =  new LottoMachine(lottoAutoGenerator);

    @Test
    void 갯수_맞게_생성() {
        Order order = new Order(5);
        LottoList lottoList = lottoMachine.issueAutoLottoList(order);
        assertThat(lottoList.getLottoListSize()).isEqualTo(5);
    }
}