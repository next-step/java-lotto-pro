package lotto.model;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class LottoPlayServiceTest {

    private final LottoPlayService lottoPlayService = new LottoPlayService();
    private Lottos lottos;

    @BeforeEach
    void setUp() {
        lottos = new Lottos(3);
        lottos.addLotto(new Lotto(Arrays.asList(1, 3, 5, 7, 9, 10)));
        lottos.addLotto(new Lotto(Arrays.asList(7, 10, 15, 20, 25, 35)));
        lottos.addLotto(new Lotto(Arrays.asList(3, 7, 20, 35, 43, 45)));
    }

    @DisplayName("입력받은 구매금액을 로또 개수로 변환한다.")
    @ParameterizedTest(name = "[{0}]원 -> [{1}]게임")
    @CsvSource(value = {"10000:10", "5000:5", "3000:3"}, delimiter = ':')
    void buyLottoCount(String moneyWord, int expectedPlayCount) {
        assertEquals(expectedPlayCount, lottoPlayService.buyLottoCount(moneyWord));
    }

    @DisplayName("로또 구매개수만큼 로또게임을 진행하고 로또목록에 등록한다.")
    @ParameterizedTest
    @ValueSource(ints = {10, 15, 5})
    void generateLottoByCount(int buyLottoCount) {
        Lottos lottos = lottoPlayService.generateLottoByCount(buyLottoCount);
        assertThat(lottos.lottoCount()).isEqualTo(buyLottoCount);
    }

    @DisplayName("로또 게임 결과(일치한 개수, 수익률)를 확인한다.")
    @Test
    void playLottoGame() {
        List<Integer> winningNumberList = Arrays.asList(3, 7, 10, 35, 43, 45);
        lottoPlayService.playLottoGame(lottos, winningNumberList);

        assertEquals(2, lottos.getResultCount(3));
        assertEquals(0, lottos.getResultCount(4));
        assertEquals(1, lottos.getResultCount(5));
        assertEquals(0, lottos.getResultCount(6));
        assertEquals((double) 1_510_000 / 3000, lottos.getResultProfitRate());
    }




}
