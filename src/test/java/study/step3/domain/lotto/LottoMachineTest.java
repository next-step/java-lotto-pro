package study.step3.domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {

    @Test
    @DisplayName("구입 금액이 주어지면 구입 금액에 해당되는 로또를 발급한다 (개당 1,000원)")
    void issue_lottoGroup_if_given_money_test() {
        LottoMachine lottoMachine = new LottoMachine(PurchaseMoney.of(14_000L), new RandomLottoIssuanceStrategy());
        Lottos lottos = lottoMachine.issueLottos();
        assertThat(lottos.size()).isEqualTo(14);
    }
}
