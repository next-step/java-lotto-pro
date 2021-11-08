package lotto.domain.number;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.*;

import lotto.exception.*;

class ManualTicketsCountTest {

    @DisplayName("정적팩토리 메서드를 이용하여 메서드를 생성하면 객체가 만들어진다.")
    @Test
    void createTest() {
        assertThat(ManualTicketsCount.from(1)).isInstanceOf(ManualTicketsCount.class);
    }

    @DisplayName("수동 구매 티켓 수가 음수이면 예외를 던진다.")
    @Test
    void exceptionTest() {
        assertThatThrownBy(() -> ManualTicketsCount.from(-1)).isInstanceOf(OutOfBoundException.class);
    }
}
