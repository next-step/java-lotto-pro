package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {
    @Test
    @DisplayName("발급된 로또 총 갯수를 확인한다.")
    void 발급된_로또_총갯수_확인() {
        Lotto manualLotto1 = new Lotto(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        Lotto manualLotto2 = new Lotto(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)));

        Lottos lottos = LottoMachine.issueLottos(Arrays.asList(manualLotto1, manualLotto2), 100);
        assertThat(lottos.getLottos().size()).isEqualTo(100);
    }
}
