package lotto.domain;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

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
        //WHEN
        PurchasePrice price = PurchasePrice.valueOf(5000);
        //THEN
        assertThat(price).isEqualTo(PurchasePrice.valueOf(5000));
    }

    @ParameterizedTest(name = "유효하지 않은 금액 테스트 : " + ParameterizedTest.ARGUMENTS_PLACEHOLDER)
    @ValueSource(ints = {0, 500, -5000, 350, 990})
    public void T2_invalid(int candidate) {
        //THEN
        assertThatThrownBy(() -> PurchasePrice.valueOf(candidate)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또를 구입할 금액이 부족합니다.");
    }

    @Test
    @DisplayName("로또 금액에 대한 로또구매개수 테스트")
    public void T03_validGetLottos() {
        //GIVEN
        Lottos lottos = new Lottos(Arrays.asList(firstPlaceLotto, thirdPlaceLotto), PurchasePrice.valueOf(2000));
        //WHEN
        Ranks ranks = lottos.getResults(winningLotto);
        //THEN
        assertThat(ranks.countPlace(Rank.FIRST)).isEqualTo(1);
        assertThat(ranks.countPlace(Rank.THIRD)).isEqualTo(1);
        assertThat(ranks.countPlace(Rank.FIFTH)).isEqualTo(0);
    }


    @Test
    @DisplayName("로또 금액에 맞게 로또구매개수 테스트 실패")
    public void T04_invalidGetLottos() {
        //THEN
        assertThatThrownBy(() -> new Lottos(Arrays.asList(firstPlaceLotto, thirdPlaceLotto), PurchasePrice.valueOf(50000)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구매 수량이 일치하지 않습니다.");
    }

    @Test
    @DisplayName("구매 수량 일치 테스트")
    public void T5_purchaseCount() {
        //GIVEN
        PurchasePrice purchasePrice = PurchasePrice.valueOf(5000);
        //THEN
        assertThat(purchasePrice.isMatchCount(5)).isTrue();
        assertThat(purchasePrice.isMatchCount(6)).isFalse();
    }

    @Test
    @DisplayName("수동_로또구매개수_테스트")
    public void T6_manualCountTest() {
        //GIVEN
        int possibleToBuyCount = 5;
        int impossibleToBuyCount = 6;
        //WHEN
        PurchasePrice purchasePrice = PurchasePrice.valueOf(5000);
        //THEN
        assertThat(purchasePrice.isAbleToBuy(possibleToBuyCount)).isTrue();
        assertThat(purchasePrice.isAbleToBuy(impossibleToBuyCount)).isFalse();
    }

    @Test
    @DisplayName("자동 구매 테스트")
    public void T7_() {
        //GIVEN
        int manualCnt = 3;
        int autoCnt = 2;
        //WHEN
        PurchasePrice price = PurchasePrice.valueOf(5000);
        //THEN
        assertThat(price.isMatchCount(manualCnt + autoCnt)).isTrue();
        //WHEN
        List<Lotto> automaticLottoList = price.buyAutomaticLottoExceptManualCnt(manualCnt);
        //THEN
        assertThat(automaticLottoList.size()).isEqualTo(autoCnt);
    }
}
