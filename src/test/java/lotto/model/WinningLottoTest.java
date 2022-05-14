package lotto.model;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

    private Lottos lottos;

    @BeforeEach
    void setUp() {
        lottos = new Lottos(3);
        lottos.addLotto(new Lotto(Arrays.asList(1, 3, 5, 7, 9, 10)));
        lottos.addLotto(new Lotto(Arrays.asList(7, 10, 15, 20, 25, 35)));
        lottos.addLotto(new Lotto(Arrays.asList(3, 7, 20, 35, 43, 45)));
    }

    @DisplayName("당첨로또 번호가 1~45 사이가 아닌 경우 검증")
    @Test
    void playLottoGame_not_lotto_number() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningLotto(Arrays.asList(3, 7, 10, 35, 43, 46)))
                .withMessage("[ERROR] 로또 번호는 1~45 사이의 숫자여야합니다.");

        assertThatIllegalArgumentException()
                .isThrownBy(() ->  new WinningLotto(Arrays.asList(0, 7, 10, 35, 43, 46)))
                .withMessage("[ERROR] 로또 번호는 1~45 사이의 숫자여야합니다.");
    }

    @DisplayName("당첨로또 번호가 6개가 아닌 경우 검증")
    @Test
    void playLottoGame_non_six_number() {
        assertThatIllegalArgumentException()
                .isThrownBy(() ->  new WinningLotto( Arrays.asList(3, 7, 10, 35)))
                .withMessage("[ERROR] 로또 번호는 6개여야 합니다.");
    }

    @DisplayName("당첨로또 6개의 번호에 중복이 있는지 검증")
    @Test
    void playLottoGame_duplication_number() {
        assertThatIllegalArgumentException()
                .isThrownBy(() ->  new WinningLotto( Arrays.asList(3, 7, 10, 10, 25, 35)))
                .withMessage("[ERROR] 6개의 로또 번호에 중복이 있습니다.");
    }

    @DisplayName("로또 게임 결과(일치한 개수, 수익률)를 확인한다.")
    @Test
    void playLottoGame() {
        WinningLotto winningLotto = new WinningLotto(Arrays.asList(3, 10, 15, 25, 35, 40));
        LottoGameResult resultLottoGame = winningLotto.compareLottos(lottos);
        assertEquals(2, resultLottoGame.matchNumberCount(3));
        assertEquals(0, resultLottoGame.matchNumberCount(4));
        assertEquals(1, resultLottoGame.matchNumberCount(5));
        assertEquals(0, resultLottoGame.matchNumberCount(6));
        assertEquals((double) 1_510_000 / 3000, resultLottoGame.calcResultProfitRate());
    }


}
