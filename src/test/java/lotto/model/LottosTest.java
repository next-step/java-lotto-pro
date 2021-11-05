package lotto.model;

import lotto.service.LottoAutoCreateFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    @DisplayName("갯수를 입력받아 로또를 여러개 생성하는 기능 검증")
    @Test
    void createLottos() {
        Lottos lottos = LottoAutoCreateFactory.createLottos(20);
        assertThat(lottos.size()).isEqualTo(20);
    }

    @DisplayName("로또 ")
    @Test
    void rankReport() {

    }
}
