package step3.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoGameTest {
    private LottoGame lottoGame;

    @BeforeEach
    void beforeEach() {
        lottoGame = new LottoGame();
    }

    @ParameterizedTest(name = "구입가능개수 반환 ({0} : {1})")
    @CsvSource(value = {"1000:1", "5000:5", "100:0"}, delimiter = ':')
    void 구입가능개수_반환(int money, int expected) {
        assertThat(LottoGame.buyCount(money)).isEqualTo(expected);
    }

    @Test
    void 투자금액_계산() {
        assertThat(lottoGame.investmentAmount(5)).isEqualTo(5000);
    }
}
