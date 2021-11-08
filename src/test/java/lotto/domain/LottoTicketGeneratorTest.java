package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoTicketGeneratorTest {

	@ParameterizedTest
	@ValueSource(ints = {0, 1, 10})
	@DisplayName("요청한 갯수에 맞게 로또 티켓번호들을 자동생성해야 한다")
	public void generateTest(int count) {
		// given
		PositiveNumber requestCount = PositiveNumber.of(count);

		// when
		LottoTickets tickets = LottoTicketGenerator.generateByCount(requestCount);

		// then
		assertThat(tickets.isEqualSize(requestCount)).isTrue();
	}
}
