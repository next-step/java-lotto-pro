package lotto.domain.number;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import lotto.exception.*;

class PaymentTest {
    private static Stream<Arguments> provideNumberOfAvailableTicketsTest() {
        return Stream.of(
            Arguments.of(Payment.from(1000), 0, 1),
            Arguments.of(Payment.from(1000), 1, 0),
            Arguments.of(Payment.from(1500), 0, 1),
            Arguments.of(Payment.from(1500), 1, 0),
            Arguments.of(Payment.from(1900), 0, 1),
            Arguments.of(Payment.from(1900), 1, 0),
            Arguments.of(Payment.from(2000), 2, 0),
            Arguments.of(Payment.from(2000), 1, 1),
            Arguments.of(Payment.from(2000), 0, 2)
        );
    }

    @DisplayName("정적팩토리 메서드를 이용하여 메서드를 생성하면 객체가 만들어진다.")
    @Test
    void create() {
        assertThat(Payment.from(1000)).isInstanceOf(Payment.class);
    }

    @DisplayName("지불금액의 수치가 1000원 미만이면 예외를 던진다.")
    @Test
    void exceptionTest() {
        assertThatThrownBy(() -> Payment.from(999)).isInstanceOf(OutOfBoundException.class);
    }

    @DisplayName("현재 보유한 금액 기준 수동티켓수를 입력받으면, 자동으로 구입 가능한 최대 티켓 수를 반환한다.")
    @ParameterizedTest
    @MethodSource("provideNumberOfAvailableTicketsTest")
    void numberOfAvailableTicketsTest(Payment payment, int manualTicketsCount, int expected) {
        assertThat(payment.numberOfAvailableTicketsAutomatically(manualTicketsCount)).isEqualTo(expected);
    }
}
