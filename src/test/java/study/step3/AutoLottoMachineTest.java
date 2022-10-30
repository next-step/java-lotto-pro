package study.step3;

import domain.AutoLottoMachine;
import domain.Lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AutoLottoMachineTest {

    private AutoLottoMachine autoLottoMachine;


    @Test
    void 로또번호_생성(){

        autoLottoMachine = new AutoLottoMachine();
        Lotto lotto = autoLottoMachine.createLottoNumber();

       assertThat(lotto).isNotNull();
    }


}