package lotto.domain.ticket;

import static lotto.fixture.Fixture.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.*;

public class TicketsTest {
    @DisplayName("정적팩토리 메서드를 이용하여 메서드를 생성하면 객체가 만들어진다.")
    @Test
    void createTest() {
        assertThat(Tickets.of(PAYMENT_14000, INTEGER_LIST_OF_MANUAL_TICKETS)).isInstanceOf(Tickets.class);
    }
}
