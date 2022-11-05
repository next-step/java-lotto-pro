package study.lotto.domain.order;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("사용자 주문 종류 테스트")
class OrderTypeTest {

    @Test
    void 사용자_주문_종류가_MANUAL_인지_확인() {
        OrderType orderType = OrderType.MANUAL;

        assertAll(
                () -> assertTrue(orderType.isManual()),
                () -> assertFalse(orderType.isAuto())
        );
    }

    @Test
    void 사용자_주문_종류가_AUTO_인지_확인() {
        OrderType orderType = OrderType.AUTO;

        assertAll(
                () -> assertFalse(orderType.isManual()),
                () -> assertTrue(orderType.isAuto())
        );
    }
}
