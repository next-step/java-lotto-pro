package study.step3.domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.step3.domain.lottonumber.LottoNumbers;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {

    @Test
    @DisplayName("구입 금액이 주어지면 구입 금액에 해당되는 로또를 자동으로 발급한다 (개당 1,000원)")
    void issue_random_lottoGroup_if_given_money_test() {
        PurchaseMoney purchaseMoney = PurchaseMoney.of(14_000L);
        LottoMachine lottoMachine = new LottoMachine();

        Lottos lottos = lottoMachine.issueRandomLottos(purchaseMoney.numberOfRandomLottos(0L));

        assertThat(lottos.size()).isEqualTo(14);
    }

    @Test
    @DisplayName("구입 금액이 주어지면 구입 금액에 해당되는 로또를 수동으로 발급한다 (개당 1,000원)")
    void issue_manual_lottoGroup_if_given_money_test() {
        LottoMachine lottoMachine = new LottoMachine();

        Lottos lottos = lottoMachine.issueManualLottos(Arrays.asList(
                LottoNumbers.of(1, 2, 3, 4, 5, 6),
                LottoNumbers.of(2, 3, 6, 1, 11, 12)
        ));

        assertThat(lottos.size()).isEqualTo(2);
    }
}
