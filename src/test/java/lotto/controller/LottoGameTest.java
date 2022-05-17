package lotto.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.constant.LottoRank;
import lotto.model.Lotto;
import lotto.model.LottoGameResult;
import lotto.model.LottoNumber;
import lotto.model.LottoNumbers;
import lotto.model.Money;
import lotto.model.WinningLotto;
import lotto.model.generator.LottoGenerator;
import lotto.model.Lottos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGameTest {

    private List<Lotto> lottos;

    @BeforeEach
    void setUp() {
        lottos = new ArrayList<>();
        lottos.add(new Lotto(Arrays.asList(1, 3, 5, 7, 9, 10)));
        lottos.add(new Lotto(Arrays.asList(7, 10, 15, 20, 25, 35)));
        lottos.add(new Lotto(Arrays.asList(3, 7, 20, 35, 43, 45)));
    }

    @DisplayName("로또 목록 생성 테스트")
    @Test
    void generateLottos() {
        // 테스트를 위해 로또 게임 수는 3번 한정한다.
        String money = "3000";
        LottoGenerator lottoGenerator = (lottoPaper)->new Lottos(lottos);
        assertThat(LottoGame.generateLottosByMoney(new Money(money), lottoGenerator)).isEqualTo(new Lottos(lottos));
    }

    @DisplayName("로또 결과 생성 테스트")
    @Test
    void resultWinningGame() {
        WinningLotto winningLotto = new WinningLotto(new LottoNumbers(Arrays.asList("3","7","10","20","35","45")),new LottoNumber(40));
        LottoGameResult lottoGameResult = LottoGame.resultWinningGame(winningLotto,new Lottos(lottos));
        assertThat(lottoGameResult.rankCount(LottoRank.THIRD)).isEqualTo(1);
        assertThat(lottoGameResult.rankCount(LottoRank.SECOND)).isEqualTo(1);
        assertThat(lottoGameResult.totalWinningAmount()).isEqualTo(1_555_000);
    }
}
