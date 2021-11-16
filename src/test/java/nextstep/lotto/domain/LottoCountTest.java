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
        LottoCount lottoCount = new LottoCount(new PurchaseLottoAmount(14000L, 3L));

        // return
        Assertions.assertThat(lottoCount.getAutoLottoCount()).isEqualTo(11);

        mockRandoms.close();
    }
}
