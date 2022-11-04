package study.lotto.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import study.message.LottoExceptionCode;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("OrderService 테스트")
class OrderServiceTest {

    private final OrderService orderService = new OrderService();

    @Test
    void order_생성_테스트() {
        orderService.createOrder("10000");

        assertThat(orderService.findOne()).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(strings = { "-", "-1", "-2", "0", "100", "500", "900" })
    void Order를_생성할때_잘못된_구매_금액을_입력하면_IllegalArguemntException_발생(String amount) {
        assertThatThrownBy(() -> {
            orderService.createOrder(amount);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoExceptionCode.INSUFFICIENT_FUNDS.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = { -2, -1, 20, 30 })
    void 잘못된_수동_구매_수량을_입력하면_IllegalArgumentException_발생(int manualQuantity) {
        orderService.createOrder("15000");

        assertThatThrownBy(() -> {
            orderService.addManualQuantity(manualQuantity);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoExceptionCode.FAILED_MANUAL_ORDER.getMessage());
    }

    @Test
    void 수동_로또를_더_구매_가능() {
        orderService.createOrder("10000");
        orderService.addManualQuantity(2);
        orderService.addManualLotto("1, 2, 3, 4, 5, 6");

        assertTrue(orderService.canOrderManualLotto());
    }

    @Test
    void 수동_로또를_더_구매_불가능() {
        orderService.createOrder("10000");
        orderService.addManualQuantity(1);
        orderService.addManualLotto("1, 2, 3, 4, 5, 6");

        assertFalse(orderService.canOrderManualLotto());
    }
}
