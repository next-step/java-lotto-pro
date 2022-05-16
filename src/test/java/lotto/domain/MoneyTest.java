package lotto.domain;

import lotto.constants.Constants;
import lotto.constants.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MoneyTest {
    @DisplayName("최소값 보다 작은값 입력 시 예외 처리")
    @Test
    void test_최소값_보다_작을때() {
        //given & when & then
        assertThatThrownBy(() -> Money.from(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.LESS_THEN_MIN_MONEY);
    }

    @DisplayName("로또 구입 가능한 최소 금액이 아닌경우 체크")
    @Test
    void test_로또_구입_최소_금액_아닌경우() {
        //given
        int inputMoney = 500;
        Money money = Money.from(inputMoney);
        //when & then
        assertThat(money.isLessThenLottoPrice()).isTrue();
    }

    @DisplayName("최대 구입 가능한 개수 확인")
    @Test
    void test_최대_구입_개수() {
        //given
        int inputMoney = 100500;
        Money money = Money.from(inputMoney);
        //when & then
        assertThat(money.purchaseCount()).isEqualTo(Constants.MAX_PURCHASE_COUNT);
    }

    @DisplayName("최대 구입 가능한 개수가 넘을 경우 예외 처리")
    @Test
    void test_최대_구입_개수_오류() {
        //given
        int inputMoney = 101000;
        Money money = Money.from(inputMoney);
        //when & then
        assertThatThrownBy(money::purchaseCount)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.MAX_PURCHASE_LOTTO);
    }

    @DisplayName("구입 금액만큼 가능한 개수 확인")
    @Test
    void test_로또_구입_개수() {
        //given
        Money money = Money.from(5500);
        //when & then
        assertThat(money.purchaseCount()).isEqualTo(5);
    }

    @DisplayName("구입 금액만큼 수동 구입 후 자동 가능한 개수 확인")
    @Test
    void test_로또_수동_구입후_자동_개수() {
        //given
        Money money = Money.from(14000);
        int manualCount = 3;
        //when & then
        assertThat(money.autoPurchaseCount(manualCount)).isEqualTo(11);
    }
}