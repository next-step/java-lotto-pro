package nextstep.lotto.domain;

import nextstep.lotto.util.LottoRandomGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.MockedStatic;
import org.mockito.Mockito;


public class LottoCountTest {


    @DisplayName("수량에 따라서 자동으로 로또 구매하는 동작 테스트")
    @Test
    public void purchaseLottoByLottoCount() {

        // when
        MockedStatic<LottoRandomGenerator> mockRandoms = Mockito.mockStatic(LottoRandomGenerator.class);
        mockRandoms.when(() ->
                LottoRandomGenerator.pickNumberInRange(ArgumentMatchers.anyInt(), ArgumentMatchers.anyInt())
        ).thenReturn(1, 2, 3, 4, 5, 6);

        // then
        PurchaseLotto purchaseLotto = new LottoCount(new PurchaseLottoAmount(1000L)).purchaseLottoByLottoCount();

        // return
        Assertions.assertThat(purchaseLotto.size()).isEqualTo(1);
        for (Lotto lotto : purchaseLotto) {
            Assertions.assertThat(lotto.toString()).isEqualTo("1, 2, 3, 4, 5, 6");
        }
    }

    @DisplayName("수량에 따라서 자동으로 로또 생성되는지 테스트")
    @Test
    public void purchaseLottoByLottoCountTest() {

        // when
        MockedStatic<LottoRandomGenerator> mockRandoms = Mockito.mockStatic(LottoRandomGenerator.class);
        mockRandoms.when(() ->
                LottoRandomGenerator.pickNumberInRange(ArgumentMatchers.anyInt(), ArgumentMatchers.anyInt())
        ).thenReturn(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);

        // then
        PurchaseLotto purchaseLotto = new LottoCount(new PurchaseLottoAmount(2000L)).purchaseLottoByLottoCount();

        // return
        Assertions.assertThat(purchaseLotto.size()).isEqualTo(2);
    }
}
