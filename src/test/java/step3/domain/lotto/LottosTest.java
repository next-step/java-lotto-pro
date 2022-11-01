package step3.domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.amount.Amount;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    @Test
    @DisplayName("구입 금액에 해당하는 로또 번호를 발급한다.")
    void createLottos() {
        Lottos lottos = new Lottos(new Amount(14000));
        assertThat(lottos.value()).hasSize(14);
    }
}
