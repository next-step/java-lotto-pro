package lotto.domain;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * packageName : lotto.domain
 * fileName : LottosTest
 * author : haedoang
 * date : 2021-11-05
 * description : 로또 리스트 테스트
 */
@TestMethodOrder(MethodOrderer.MethodName.class)
public class LottosTest {
    private LottoNumber bonusNumber;
    private WinningLotto winningLotto;
    private Lotto firstPlaceLotto;
    private Lotto thirdPlaceLotto;

    @BeforeEach
    void setUp() {
        this.bonusNumber = LottoNumber.valueOf(7);
        this.winningLotto = WinningLotto.valueOf("1,2,3,4,5,6", bonusNumber);
        this.firstPlaceLotto = Lotto.valueOf("1,2,3,4,5,6");
        this.thirdPlaceLotto = Lotto.valueOf("1,2,3,4,5,11");
    }

    @Test
    @DisplayName("로또리스트에서 결과 구하기")
    public void T1_lottos() {
        Lottos lottos = new Lottos(Arrays.asList(firstPlaceLotto, thirdPlaceLotto));
        Ranks ranks = lottos.getResults(winningLotto);
        assertThat(ranks.countPlace(Rank.FIRST)).isEqualTo(1);
        assertThat(ranks.countPlace(Rank.THIRD)).isEqualTo(1);
    }

}
