package study.lotto.domain.order;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import study.message.LottoExceptionCode;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("사용자 주문 테스트")
class OrderTest {

    @Test
    void Order_생성_테스트() {
        assertThat(new Order("1000")).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(strings = { "-", "-1", "-2", "0", "100", "500", "900" })
    void Order를_생성할때_잘못된_구매_금액을_입력하면_IllegalArguemntException_발생(String amount) {
        assertThatThrownBy(() -> {
            new Order(amount);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoExceptionCode.INSUFFICIENT_FUNDS.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = { -2, -1, 20, 30 })
    void 잘못된_수동_구매_수량을_입력하면_IllegalArgumentException_발생(int manualQuantity) {
        Order order = new Order("15000");

        assertThatThrownBy(() -> {
            order.addManualQuantity(manualQuantity);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoExceptionCode.FAILED_MANUAL_ORDER.getMessage());
    }

    @Test
    void 수동_로또를_더_구매_가능() {
        Order order = new Order("10000");
        order.addManualQuantity(2);
        order.addManualLotto("1, 2, 3, 4, 5, 6");

        assertTrue(order.canOrderManualLotto());
    }

    @Test
    void 수동_로또를_더_구매_불가능() {
        Order order = new Order("10000");
        order.addManualQuantity(1);
        order.addManualLotto("1, 2, 3, 4, 5, 6");

        assertFalse(order.canOrderManualLotto());
    }

    @Test
    void 수동_로또를_구매() {
        Order order = new Order("10000");
        order.addManualQuantity(2);
        order.addManualLotto("1, 2, 3, 4, 5, 6");
        order.addManualLotto("1, 2, 3, 4, 5, 6");

        assertThat(order.orderManually()).hasSize(2);
    }

    @Test
    void 자동_로또를_구매() {
        Order order = new Order("10000");
        order.addManualQuantity(2);
        order.addManualLotto("1, 2, 3, 4, 5, 6");
        order.addManualLotto("1, 2, 3, 4, 5, 6");

        assertThat(order.orderAutomatically()).hasSize(8);
    }
}
