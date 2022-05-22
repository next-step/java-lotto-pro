package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {
    @Test
    @DisplayName("발급된 로또 갯수를 확인한다.")
    void 발급된_로또_갯수_확인() {
        Lottos lottos = LottoMachine.issueAutoLottos(100);
        assertThat(lottos.getLottos().size()).isEqualTo(100);
    }
}
