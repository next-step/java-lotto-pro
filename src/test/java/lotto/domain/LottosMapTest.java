package lotto.domain;

import lotto.fixture.LottoFixture;
import lotto.fixture.LottosFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static lotto.fixture.WinningLottoFixture.threeMatch;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또맵")
class LottosMapTest {

    @DisplayName("로또 집합을 저장한다.")
    @ParameterizedTest
    @CsvSource(value = {"AUTO:1", "MANUAL:1"}, delimiter = ':')
    void put(LottoType type, int expected) {

        LottosMap lottosMap = new LottosMap();
        lottosMap.put(type, LottosFixture.lottos());

        assertThat(lottosMap.getLottos(type).getLottos()).hasSize(expected);
    }

    @DisplayName("로또 집합 갯수를 구한다.")
    @ParameterizedTest
    @CsvSource(value = {"AUTO:1", "MANUAL:1"}, delimiter = ':')
    void size(LottoType type, int expected) {

        LottosMap lottosMap = new LottosMap();
        lottosMap.put(type, LottosFixture.lottos());

        assertThat(lottosMap.getLottos(type).size()).isEqualTo(expected);
    }

    @DisplayName("당첨되는 로또의 갯수를 구한다.")
    @ParameterizedTest
    @CsvSource(value = {"AUTO:1", "MANUAL:1"}, delimiter = ':')
    void matchCount(LottoType type, int expected) {

        LottosMap lottosMap = new LottosMap();
        lottosMap.put(type, LottosFixture.lottos());

        assertThat(lottosMap.matchLottoCount(WinningMoney.SIX_MATCH, new WinningLotto(LottoFixture.lotto(), new Number(8)))).isEqualTo(expected);
    }

    @DisplayName("수익률을 구한다.")
    @ParameterizedTest
    @ValueSource(doubles = {2000000.0})
    void returnRate(double expected) {

        LottosMap lottosMap = new LottosMap();
        lottosMap.put(LottoType.AUTO, LottosFixture.lottos());
        lottosMap.put(LottoType.MANUAL, LottosFixture.lottos());

        assertThat(lottosMap.returnRate(new WinningLotto(LottoFixture.lotto(), new Number(8)))).isEqualTo(expected);
    }


    @DisplayName("수익률 계산이 소수점 두자리로 제한")
    @ParameterizedTest
    @ValueSource(doubles = {1.67})
    void point(double expected) {
        LottosMap lottosMap = new LottosMap();
        lottosMap.put(LottoType.MANUAL, LottosFixture.point());
        assertThat(lottosMap.returnRate(threeMatch())).isEqualTo(expected);
    }
}
