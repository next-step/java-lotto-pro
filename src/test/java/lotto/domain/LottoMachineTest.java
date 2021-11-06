package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoMachineTest {

    @Test
    @DisplayName("입력 금액만큼 로또 생성")
    public void getLottoListTest() {
        LottoMachine machine = new LottoMachine();
        Money money = new Money(5000);

        List<LottoNumber> lottoList = machine.getLottoList(money);

        assertThat(lottoList.size()).isEqualTo(money.getPurchaseCount());
    }

}