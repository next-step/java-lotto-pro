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

    @Test
    @DisplayName("로또 매치 테스트")
    public void matchLottoTest() {
        LottoMachine machine = new LottoMachine();
        Money money = new Money(5000);
        List<Number> matchNumbers
                = Arrays.asList(new Number(1), new Number(2), new Number(3), new Number(4), new Number(5), new Number(6));

        List<LottoNumber> lottoNumbers = machine.generateLotto(money.getPurchaseCount());

        assertThat(machine.matchLotto(matchNumbers, new Number(7), lottoNumbers));
    }

}