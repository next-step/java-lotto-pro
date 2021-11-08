package lotto.domain;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * packageName : lotto.domain
 * fileName : PurchasePriceTest
 * author : haedoang
 * date : 2021-11-05
 * description : 구입금액 테스트 클래스
 */
@TestMethodOrder(MethodOrderer.MethodName.class)
public class PurchasePriceTest {
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
    @DisplayName("로또 구매 금액 테스트")
    public void T01_validPurchasePrice() {
        PurchasePrice price = new PurchasePrice(5000);
        assertThat(price).isEqualTo(PurchasePrice.valueOf(5000));
    }

    @ParameterizedTest(name = "유효하지 않은 금액 테스트 : " + ParameterizedTest.ARGUMENTS_PLACEHOLDER)
    @ValueSource(ints = {0, 500, -5000, 350, 990})
    public void T2_invalid(int candidate) {
        assertThatThrownBy(() -> new PurchasePrice(candidate)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또를 구입할 금액이 부족합니다.");
    }
    @Test
    @DisplayName("로또 금액에 대한 로또구매개수 테스트")
    public void T03_validGetLottos() {
        Lottos lottos = new Lottos(Arrays.asList(firstPlaceLotto, thirdPlaceLotto), new PurchasePrice(2000));
        Ranks ranks = lottos.getResults(winningLotto);
        assertThat(ranks.countPlace(Rank.FIRST)).isEqualTo(1);
        assertThat(ranks.countPlace(Rank.THIRD)).isEqualTo(1);
        assertThat(ranks.countPlace(Rank.FIFTH)).isEqualTo(0);
    }


    @Test
    @DisplayName("로또 금액에 맞게 로또구매개수 테스트 실패")
    public void T04_invalidGetLottos() {
        assertThatThrownBy(() -> new Lottos(Arrays.asList(firstPlaceLotto, thirdPlaceLotto), PurchasePrice.valueOf(50000)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구매수량이 일치하지 않습니다.");
    }
}
