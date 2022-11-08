package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("티켓 수 테스트")
class TicketCountTest {

	@Test
	@DisplayName("티켓 수 생성")
	void createTicketCountTest() {
		TicketCount ticketCount = TicketCount.from(10);
		assertThat(ticketCount).isInstanceOf(TicketCount.class);
	}

	@Test
	@DisplayName("티켓 수 생성 시 음수를 입력할 경우 IllegalArgumentException 발생")
	void throwIllegalArgumentExceptionTest() {
		assertThatThrownBy(() -> TicketCount.from(-1))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("같은 값을 갖는 티켓 수는 같은 객체")
	void equalsTest() {
		TicketCount ticketCount = TicketCount.from(10);
		assertThat(ticketCount).isEqualTo(TicketCount.from(10));
	}

	@ParameterizedTest
	@ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
	@DisplayName("티켓 수에 따른 객체 생성")
	void mapTest(int count) {
		TicketCount ticketCount = TicketCount.from(count);
		assertThat(ticketCount.map(i -> new Object())).hasSize(count);
	}

}