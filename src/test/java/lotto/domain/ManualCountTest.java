package lotto.domain;

import lotto.constants.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ManualCountTest {
    @DisplayName("수동 구매 개수 0개인 객체 생성")
    @Test
    void test_0개_생성() {
        //given & when & then
        assertThat(ManualCount.create()).isEqualTo(ManualCount.from(0, Money.create()));
    }

    @DisplayName("수동 구매 개수가 최대 개수를 초과한 경우 예외 처리")
    @Test
    void test_최대_구매_개수_초과() {
        //given
        int manualCount = 6;
        Money purchaseMoney = Money.from(5500);
        //when & then
        assertThatThrownBy(() -> ManualCount.from(manualCount, purchaseMoney))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format(ErrorMessage.OUT_OF_RANGE_MANUAL_COUNT, purchaseMoney.purchaseCount()));
    }

    @DisplayName("구입 금액만큼 수동 구입 후 자동 가능한 개수 확인")
    @Test
    void test_수동_구입후_자동_개수() {
        //given
        Money money = Money.from(14000);
        ManualCount manualCount = ManualCount.from(3, money);
        //when & then
        assertThat(manualCount.autoPurchaseCount(money)).isEqualTo(11);
    }

    @DisplayName("수동 번호 입력 시 지정한 수동 개수를 초과한 경우 예외 처리")
    @Test
    void test_지정한_수동_개수_초과() {
        //given
        Money purchaseMoney = Money.from(5500);
        ManualCount manualCount = ManualCount.from(3, purchaseMoney);
        int alreadyPurchaseLottoTicketSize = 4;
        //when & then
        assertThatThrownBy(() -> manualCount.isRemainingCount(alreadyPurchaseLottoTicketSize))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format(ErrorMessage.GREATER_THEN_MANUAL_COUNT, manualCount));
    }
}