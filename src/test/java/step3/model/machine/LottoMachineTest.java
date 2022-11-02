package step3.model.machine;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import step3.model.lotto.LottoList;

class LottoMachineTest {
    private final LottoAutoGenerator lottoAutoGenerator = new ShuffleLottoGenerator();
    private final LottoMachine lottoMachine =  new LottoMachine(lottoAutoGenerator);

    @Test
    void 갯수_맞게_생성() {
        Order order = new Order(5, 3);
        List<String> manualInputs = new ArrayList<>();
        manualInputs.add("1,2,3,4,5,6");
        manualInputs.add("2,3,4,5,6,7");
        manualInputs.add("3,4,5,6,7,8");

        LottoList lottoList = lottoMachine.issueLottoList(order, manualInputs);
        assertThat(lottoList.getLottoListSize()).isEqualTo(5);
    }
}