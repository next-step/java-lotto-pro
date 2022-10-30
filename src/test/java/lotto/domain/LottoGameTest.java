package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("로또 게임 테스트")
class LottoGameTest {

    LottoGame lottoGame;

    @BeforeEach
    void init() {
        lottoGame = new LottoGame();
    }

    @DisplayName("로또 구입 실패")
    @ParameterizedTest(name = "{0}원으로는 로또를 구매할 수 없다.")
    @ValueSource(ints = {100, -23, 1001, 10500})
    void lotto_buy_failure(int input) {
        assertThatThrownBy(() -> lottoGame.buy(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입 후 로또의 개수 확인")
    @ParameterizedTest(name = "#{index} - {0}원으로 {1}장을 구매할 수 있다.")
    @CsvSource(value = {"1000=1", "10000=10", "96000=96"}, delimiter = '=')
    void check_the_number_of_lottery_purchases(int input, int expect) {
        assertThat(lottoGame.buy(input).ticketCount()).isEqualTo(expect);
    }

}