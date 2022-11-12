package step5.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import step5.model.Lottos;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoServiceTest {

    private LottoService lottoService;

    @BeforeEach
    void setUp() {
        this.lottoService = new LottoService();
    }

    @ParameterizedTest
    @ValueSource(ints = {100, 200, 300, 500, 900})
    @DisplayName("1000원미만의 머니와 예상되는 로또갯수가 주어질때 에러를 리턴한다.")
    void givenLessMoney_whenBuyLottosByMoney_thenThrow(int money) {
        assertThatThrownBy(() -> this.lottoService.buyLottosByMoney(money, List.of()))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("부족합니다");
    }

    @ParameterizedTest
    @CsvSource(value = {"1000,1", "13500,13", "20000,20"})
    @DisplayName("1000원이상의 머니와 예상되는 로또갯수가 주어질때 구매한 로또 갯수를 리턴한다.")
    void givenValidMoney_whenBuyLottosByMoney_thenLottos(int money, int expectedCount) {
        Lottos lottos = this.lottoService.buyLottosByMoney(money, List.of());

        assertThat(lottos.count()).isEqualTo(expectedCount);
    }

    @ParameterizedTest
    @CsvSource(value = {"1000,2", "5000,6", "4000,5"})
    @DisplayName("구입할 총 금액에서 최대 구매 가능 수동 로또 수를 초과하면 에러를 리턴한다.")
    void givenInvalidManualLottoCount_whenValidManualLottosCount_thenThrow(int money, int manualLottosCount) {
        assertThatThrownBy(() -> this.lottoService.validManualLottosCount(money, manualLottosCount))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("수동 구매가 가능한 로또 개수는 최대");
    }
}
