package step3.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoGameTest {
    private LottoGame lottoGame;

    @BeforeEach
    void beforeEach() {
        lottoGame = new LottoGame();
    }

    @ParameterizedTest(name = "입력된 금액에 따른 구입가능개수를 반환한다. ({0} : {1})")
    @CsvSource(value = {"1000:1", "5000:5", "100:0"}, delimiter = ':')
    void 구입가능개수_반환(int money, int expected) {
        assertThat(LottoGame.buyCount(money)).isEqualTo(expected);
    }

    @DisplayName("실제 로또를 구입하는데 투자된 금액을 계산한다.")
    @Test
    void 투자금액_계산() {
        assertThat(lottoGame.investmentAmount(5)).isEqualTo(5_000);
    }
}
