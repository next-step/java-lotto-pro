package lotto.domain;

import lotto.fixture.LottosFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또맵")
class LottosMapTest {

    @DisplayName("로또 집합을 저장한다.")
    @ParameterizedTest
    @CsvSource({"AUTO", "MANUAL"})
    void putManualLottos(LottoType type) {

        LottosMap lottosMap = new LottosMap();
        lottosMap.put(type, LottosFixture.lottos());

        assertThat(lottosMap.getLottos(type).getLottos()).hasSize(1);
    }
}
