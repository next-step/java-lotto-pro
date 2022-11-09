package study.step3;

import domain.AutoLottoMachine;
import domain.Lotto;

import domain.Lottos;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class AutoLottoMachineTest {
    private AutoLottoMachine autoLottoMachine;

    @Test
    void 로또번호_생성() {

        Lottos lottos = new Lottos(new ArrayList<>());
        autoLottoMachine = new AutoLottoMachine(3, lottos);
        autoLottoMachine.purchaseLotto();

        assertThat(lottos).isNotNull();
    }


}