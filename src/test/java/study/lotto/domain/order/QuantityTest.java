package study.lotto.domain.order;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import study.message.LottoExceptionCode;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("사용자 주문 수량 테스트")
class QuantityTest {

    @ParameterizedTest
    @ValueSource(strings = { "-", "-1", "0", "100", "500", "800" })
    void 숫자가_아니거나_0이하의_숫자이거나_로또_1장_가격보다_작으면_IllegalArgumentException_발생(String amount) {
        assertThatThrownBy(() -> {
            new Quantity(amount);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoExceptionCode.INSUFFICIENT_FUNDS.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 5, 10 })
    void 수동_구매_수량으로_자동_구매_수량을_구한다(int manualQuantity) {
        Quantity quantity = new Quantity("20000");

        assertEquals(20-manualQuantity, quantity.getAutoQuantity(manualQuantity));
    }

    @ParameterizedTest
    @ValueSource(ints = { -1, -2, 21, 22 })
    void 잘못된_수동_구매_수량을_입력하면_전체_수량이_자동_구매로_계산된다(int manualQuantity) {
        Quantity quantity = new Quantity("20000");

        assertEquals(20, quantity.getAutoQuantity(manualQuantity));
    }

    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 5, 10 })
    void 입력된_수동_구매_수량이_가능한_수량인지_확인(int manualQuantity) {
        Quantity quantity = new Quantity("20000");

        assertTrue(quantity.isValidManualOrder(manualQuantity));
    }

    @ParameterizedTest
    @ValueSource(ints = { -1, -2, 21, 22 })
    void 입력된_수동_구매_수량이_구매_불가능한_경우_확인(int manualQuantity) {
        Quantity quantity = new Quantity("20000");

        assertFalse(quantity.isValidManualOrder(manualQuantity));
    }
}
