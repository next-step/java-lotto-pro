package step3.domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.factory.Automatic;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    @Test
    @DisplayName("구입 금액에 해당하는 로또 번호를 발급한다.")
    void createLottos() {
        List<Lotto> list = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            list.add(new Lotto(new Automatic()));
        }
        Lottos lottos = new Lottos(list);
        assertThat(lottos.value()).hasSize(14);
    }
}
