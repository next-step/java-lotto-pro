package lotto.domain;

import lotto.domain.factory.LottoFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottosTest {

    @Test
    @DisplayName("로또를 2번 추가하면 Lottos 사이즈는 2이다")
    void add() {
        Lottos lottos = new Lottos();
        lottos.add(LottoFactory.createAuto());
        lottos.add(LottoFactory.createAuto());
        assertThat(lottos.getLottos()).hasSize(2);

    }

}
