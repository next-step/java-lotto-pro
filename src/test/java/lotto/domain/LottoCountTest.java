package lotto.domain;

import lotto.constants.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LottoCountTest {
    @DisplayName("수동 구매 개수가 최대 개수를 초과한 경우 예외 처리")
    @Test
    void test_최대_구매_개수_초과() {
        //given
        Money purchaseMoney = Money.from(5500);
        ManualCount manualCount = ManualCount.from(6);
        //when & then
        assertThatThrownBy(() -> LottoCount.from(purchaseMoney, manualCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format(ErrorMessage.OUT_OF_RANGE_MANUAL_COUNT, purchaseMoney.purchaseCount()));
    }

    @DisplayName("수동 구입 개수 확인")
    @Test
    void test_수동_개수() {
        //given
        Money money = Money.from(14000);
        ManualCount manualCount = ManualCount.from(3);
        LottoCount lottoCount = LottoCount.from(money, manualCount);
        //when & then
        assertThat(lottoCount.manualCount()).isEqualTo(3);
    }

    @DisplayName("구입 금액만큼 수동 구입 후 자동 가능한 개수 확인")
    @Test
    void test_수동_구입후_자동_개수() {
        //given
        Money money = Money.from(14000);
        ManualCount manualCount = ManualCount.from(3);
        LottoCount lottoCount = LottoCount.from(money, manualCount);
        //when & then
        assertThat(lottoCount.autoCount()).isEqualTo(11);
    }
}