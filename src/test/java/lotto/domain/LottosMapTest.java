package lotto.domain;

import lotto.fixture.LottosFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또맵")
class LottosMapTest {

    @DisplayName("수동 로또 집합을 저장한다.")
    @Test
    void putManualLottos() {
        LottosMap lottosMap = new LottosMap();
        lottosMap.putManualLottos(LottosFixture.lottos());
        assertThat(lottosMap.getManualLottos().getLottos()).hasSize(1);
    }

    @DisplayName("자동 로또 집합을 저장한다.")
    @Test
    void putAutoLottos() {
        LottosMap lottosMap = new LottosMap();
        lottosMap.putAutoLottos(LottosFixture.lottos());
        assertThat(lottosMap.getAutoLottos().getLottos()).hasSize(1);
    }
}
