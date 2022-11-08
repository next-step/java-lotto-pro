package step4.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import step4.model.Lottos;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoServiceTest {

    private LottoService lottoService;

    @BeforeEach
    private void setUp() {
        this.lottoService = new LottoService();
    }

    @ParameterizedTest
    @ValueSource(ints = {100, 200, 300, 500, 900})
    @DisplayName("1000원미만의 머니와 예상되는 로또갯수가 주어질때 에러를 리턴한다.")
    void givenLessMoney_whenBuyLottosByMoney_thenThrow(int money) {
        assertThatThrownBy(() -> this.lottoService.buyLottosByMoney(money))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("부족합니다");
    }

    @ParameterizedTest
    @CsvSource(value = {"1000,1", "13500,13", "20000,20"})
    @DisplayName("1000원이상의 머니와 예상되는 로또갯수가 주어질때 구매한 로또 갯수를 리턴한다.")
    void givenValidMoney_whenBuyLottosByMoney_thenLottos(int money, int expectedCount) {
        Lottos lottos = this.lottoService.buyLottosByMoney(money);

        assertThat(lottos.count()).isEqualTo(expectedCount);
    }
}
