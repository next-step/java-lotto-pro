package lotto.domain;

import lotto.domain.LottoGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGameTest {

    @ParameterizedTest
    @CsvSource(value = {"1000,1", "5000,5"}, delimiter = ',')
    @DisplayName("로또 구매 가능 갯수 테스트")
    public void calculateLottoAmountTest(int payAmount, int lottoAmount){
        LottoGame lottoGame = new LottoGame(payAmount);
        assertThat(lottoGame.calculateLottoAmount()).isEqualTo(lottoAmount);
    }
}