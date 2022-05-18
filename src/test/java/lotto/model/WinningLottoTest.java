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

    @DisplayName("당첨로또 6개의 번호와 보너스 번호에 중복이 있는지 검증")
    @Test
    void playLottoGame_duplication_bonus_number() {
        LottoNumber bonusNumber = new LottoNumber(7);
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningLotto(
                        new LottoNumbers(Arrays.asList("3", "7", "10", "15", "25", "35")),
                        bonusNumber)
                )
                .withMessage("[ERROR] 보너스 번호가 이미 로또 번호에 존재합니다.");
    }

    @DisplayName("보너스볼이 추가된 로또 게임 결과(일치한 개수, 총 상금)를 확인한다.")
    @Test
    void playLottoGame_bonus_number() {
        LottoNumber bonusNumber = new LottoNumber(20);
        WinningLotto winningLotto = new WinningLotto(
                new LottoNumbers(Arrays.asList("3", "7", "10", "35", "43", "45")), bonusNumber
        );
        LottoGameResult resultLottoGame = winningLotto.compareLottos(lottos);
        assertAll(
                () -> assertEquals(2, resultLottoGame.rankCount(LottoRank.FOURTH)),
                () -> assertEquals(0, resultLottoGame.rankCount(LottoRank.THIRD)),
                () -> assertEquals(0, resultLottoGame.rankCount(LottoRank.SECOND)),
                () -> assertEquals(1, resultLottoGame.rankCount(LottoRank.SECOND_BONUS)),
                () -> assertEquals(0, resultLottoGame.rankCount(LottoRank.FIRST)),
                () -> assertEquals(30_010_000, resultLottoGame.totalWinningAmount())
        );
    }
}
