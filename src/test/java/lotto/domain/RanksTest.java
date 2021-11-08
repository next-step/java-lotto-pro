package lotto.domain;

import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.List;

import static lotto.common.utils.MathUtil.calculateYield;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * packageName : lotto.domain
 * fileName : RanksTest
 * author : haedoang
 * date : 2021-11-05
 * description :
 */
@TestMethodOrder(MethodOrderer.MethodName.class)
public class RanksTest {
    private LottoNumber bonusNumber;
    private WinningLotto winningLotto;
    private Lotto firstPlaceLotto;
    private Lotto secondPlaceLotto;
    private Lotto thirdPlaceLotto;
    private Lotto fourthPlaceLotto;
    private Lotto fifthPlaceLotto;
    private Lotto noPlaceLotto;

    @BeforeEach
    void setUp() {
        this.bonusNumber = LottoNumber.valueOf(7);
        this.winningLotto = WinningLotto.valueOf("1,2,3,4,5,6", bonusNumber);
        this.firstPlaceLotto = Lotto.valueOf("1,2,3,4,5,6");
        this.secondPlaceLotto = Lotto.valueOf("1,2,3,4,5,7");
        this.thirdPlaceLotto = Lotto.valueOf("1,2,3,4,5,11");
        this.fourthPlaceLotto = Lotto.valueOf("1,2,3,4,11,12");
        this.fifthPlaceLotto = Lotto.valueOf("1,2,3,11,12,13");
        this.noPlaceLotto = Lotto.valueOf("9,10,11,12,13,14");
    }

    @Test
    @DisplayName("당첨금액 구하기")
    public void T1_totalRewards() {
        Lottos lottos = new Lottos(Arrays.asList(firstPlaceLotto, thirdPlaceLotto));
        Ranks ranks = lottos.getResults(winningLotto);
        assertThat(ranks.totalRewards()).isEqualTo(Rank.FIRST.getWinningMoney() + Rank.THIRD.getWinningMoney());
    }

    @Test
    @DisplayName("수익율 구하기")
    public void T2_earningRatio() {
        List<Lotto> lottoList = Arrays.asList(noPlaceLotto, noPlaceLotto, thirdPlaceLotto, noPlaceLotto);
        Lottos lottos = new Lottos(lottoList);
        Ranks ranks = lottos.getResults(winningLotto);
        assertThat(ranks.earningRatio()).isEqualTo(calculateYield(Rank.THIRD.getWinningMoney(), PurchasePrice.LOTTO_PRICE * lottoList.size()));
    }

    @Test
    @DisplayName("수익율 구하기2")
    public void T2_earningRatio2() {
        List<Lotto> lottoList = Arrays.asList(fourthPlaceLotto, firstPlaceLotto, noPlaceLotto, noPlaceLotto, noPlaceLotto, noPlaceLotto, noPlaceLotto, noPlaceLotto, noPlaceLotto, noPlaceLotto, noPlaceLotto, noPlaceLotto, noPlaceLotto, noPlaceLotto);
        Lottos lottos = new Lottos(lottoList);
        Ranks ranks = lottos.getResults(winningLotto);
        assertThat(ranks.earningRatio()).isEqualTo(calculateYield(Rank.FIRST.getWinningMoney() + Rank.FOURTH.getWinningMoney(), PurchasePrice.LOTTO_PRICE * lottoList.size()));
    }

}
