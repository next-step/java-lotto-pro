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
    void put(LottoType type) {

        LottosMap lottosMap = new LottosMap();
        lottosMap.put(type, LottosFixture.lottos());

        assertThat(lottosMap.getLottos(type).getLottos()).hasSize(1);
    }

    @DisplayName("로또 집합 갯수를 구한다.")
    @ParameterizedTest
    @CsvSource({"AUTO", "MANUAL"})
    void size(LottoType type) {

        LottosMap lottosMap = new LottosMap();
        lottosMap.put(type, LottosFixture.lottos());

        assertThat(lottosMap.getLottos(type).size()).isEqualTo(1);
    }
}
