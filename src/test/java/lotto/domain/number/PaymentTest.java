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
            Arguments.of(Payment.from(1000), 1),
            Arguments.of(Payment.from(1500), 1),
            Arguments.of(Payment.from(1900), 1),
            Arguments.of(Payment.from(2000), 2)
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

    @DisplayName("금액이 주어지면, 구입 가능한 최대 티켓 수를 반환한다.")
    @ParameterizedTest
    @MethodSource("provideNumberOfAvailableTicketsTest")
    void numberOfAvailableTicketsTest(Payment payment, int expected) {
        assertThat(payment.numberOfAvailableTickets()).isEqualTo(expected);
    }
}
