package step3.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import step3.model.Lottos;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoServiceTest {

    private LottoService lottoService;

    @BeforeEach
    public void setUp() {
        this.lottoService = new LottoService();
    }

    @ParameterizedTest
    @ValueSource(ints = {100, 200, 300, 500, 900})
    void givenLessMoney_whenBuyLottosByMoney_thenThrow(int money) {
        assertThatThrownBy(() -> this.lottoService.buyLottosByMoney(money))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("부족합니다");
    }

    @ParameterizedTest
    @CsvSource(value = {"1000,1", "13500,13", "20000,20"})
    void givenValidMoney_whenBuyLottosByMoney_thenLottos(int money, int expectedCount) {
        Lottos lottos = this.lottoService.buyLottosByMoney(money);

        assertThat(lottos.count()).isEqualTo(expectedCount);
    }
}