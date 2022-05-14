package lotto.model;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.constant.LottoRank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

    private Lottos lottos;

    @BeforeEach
    void setUp() {
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(new Lotto(Arrays.asList(1, 3, 5, 7, 9, 10)));
        lottoList.add(new Lotto(Arrays.asList(7, 10, 15, 20, 25, 35)));
        lottoList.add(new Lotto(Arrays.asList(3, 7, 20, 35, 43, 45)));
        lottos = new Lottos(lottoList);
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

    @DisplayName("로또 게임 결과(일치한 개수, 총 상금)를 확인한다.")
    @Test
    void playLottoGame() {
        WinningLotto winningLotto = new WinningLotto(Arrays.asList(3, 7, 10, 35, 43, 45));
        LottoGameResult resultLottoGame = winningLotto.compareLottos(lottos);
        assertEquals(2, resultLottoGame.rankCount(LottoRank.FOURTH));
        assertEquals(0, resultLottoGame.rankCount(LottoRank.THIRD));
        assertEquals(1, resultLottoGame.rankCount(LottoRank.SECOND));
        assertEquals(0, resultLottoGame.rankCount(LottoRank.FIRST));
        assertEquals(1_510_000,resultLottoGame.totalWinningAmount());
    }


}
