package study.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import study.lotto.domain.order.UserOrder;
import study.message.LottoExceptionCode;
import study.util.NumberUtil;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("사용자 로또 주문과 관련된 테스트")
class UserOrderTest {

    @ParameterizedTest
    @ValueSource(strings = { "-1", "-2", "100", "500" })
    void 로또_1개_가격보다_작은_금액이_입력되면_IllegalArgumentException(String amount) {
        assertThatThrownBy(() -> {
            UserOrder userOrder = new UserOrder(amount);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoExceptionCode.INSUFFICIENT_FUNDS.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = { 11, 20, 30 })
    void 전체_구매_수량을_초과하는_수동_구매가_입력되면_IllegalArgumentException(int quantity) {
        assertThatThrownBy(() -> {
            UserOrder userOrder = new UserOrder("1000");
            userOrder.checkManualQuantity(quantity);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoExceptionCode.FAILED_MANUAL_ORDER.getMessage());
    }

    @ParameterizedTest
    @CsvSource(value = { "1:19", "2:18", "5:15", "10:10" }, delimiter = ':')
    void 주문_테스트(int manualQuantity, int autoQuantity) {
        UserOrder userOrder = new UserOrder("20000");
        userOrder.prepareOrder(manualQuantity);

        IntStream.range(NumberUtil.INIT_ZERO, manualQuantity).forEach((i) -> {
            userOrder.createManualOrder("1, 2, 3, 4, 5, 6");
        });

        userOrder.order();

        assertEquals(manualQuantity + "," + autoQuantity, userOrder.toString());
    }
}
