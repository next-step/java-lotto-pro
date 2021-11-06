package lotto.domain;

import lotto.common.Constants;
import org.junit.jupiter.api.*;

import java.util.Arrays;

import static lotto.common.MathUtil.calculateYield;
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
    Lotto winning;
    Lotto firstPlaceLotto;
    Lotto thirdPlaceLotto;
    Lotto fourthPlaceLotto;
    Lotto noPlaceLotto;

    @BeforeEach
    void setUp() {
        this.winning = new Lotto(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)));
        this.firstPlaceLotto = new Lotto(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)));
        this.thirdPlaceLotto = new Lotto(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(10), new LottoNumber(12)));
        this.fourthPlaceLotto = new Lotto(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(33), new LottoNumber(10), new LottoNumber(12)));
        this.noPlaceLotto = new Lotto(Arrays.asList(new LottoNumber(44), new LottoNumber(43), new LottoNumber(42), new LottoNumber(33), new LottoNumber(10), new LottoNumber(12)));
    }

    @Test
    @DisplayName("당첨금액 구하기")
    public void T1_totalRewards() {
        Lottos lottos = new Lottos(Arrays.asList(firstPlaceLotto, thirdPlaceLotto));
        Ranks ranks = lottos.getResults(winning);
        assertThat(ranks.totalRewards()).isEqualTo(Constants.REWARD_1ST + Constants.REWARD_3RD);
    }

    @Test
    @DisplayName("수익율 구하기")
    public void T2_earningRatio() {
        Lottos lottos = new Lottos(Arrays.asList(fourthPlaceLotto, noPlaceLotto, noPlaceLotto, noPlaceLotto, noPlaceLotto, noPlaceLotto, noPlaceLotto, noPlaceLotto, noPlaceLotto, noPlaceLotto, noPlaceLotto, noPlaceLotto, noPlaceLotto, noPlaceLotto));
        Ranks ranks = lottos.getResults(winning);
        assertThat(ranks.earningRatio()).isEqualTo(calculateYield(Constants.REWARD_4TH, PurchasePrice.LOTTO_PRICE * 14));
    }

    @Test
    @DisplayName("수익율 구하기2")
    public void T2_earningRatio2() {
        Lottos lottos = new Lottos(Arrays.asList(fourthPlaceLotto, firstPlaceLotto, noPlaceLotto, noPlaceLotto, noPlaceLotto, noPlaceLotto, noPlaceLotto, noPlaceLotto, noPlaceLotto, noPlaceLotto, noPlaceLotto, noPlaceLotto, noPlaceLotto, noPlaceLotto));
        Ranks ranks = lottos.getResults(winning);
        assertThat(ranks.earningRatio()).isEqualTo(calculateYield(Constants.REWARD_4TH + Constants.REWARD_1ST, PurchasePrice.LOTTO_PRICE * 14));
    }

}
