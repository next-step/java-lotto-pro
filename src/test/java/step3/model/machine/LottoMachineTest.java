package step3.model.machine;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

class LottoMachineTest {
    private LottoAutoGenerator lottoAutoGenerator = new ShuffleLottoGenerator();
    private LottoMachine lottoMachine =  new LottoMachine(lottoAutoGenerator);

    @Test
    void 갯수_맞게_생성() {
        Order order = new Order(5);
        int lottoCount = lottoMachine.issueAutoLottoList(order).size();
        assertThat(lottoCount).isEqualTo(5);
    }
}