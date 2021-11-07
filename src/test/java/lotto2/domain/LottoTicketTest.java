package lotto2.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTicketTest {

	@Test
	@DisplayName("로또 번호 6개로 티켓이 생성되어야 한다")
	public void ofTest() {
		// given
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

		// when
		LottoTicket ticket = LottoTicket.of(numbers);

		// then
		assertThat(ticket).isEqualTo(LottoTicket.of(numbers));

	}

	@Test
	@DisplayName("로또 번호는 6개여야 하며, 중복이 없어야 한다")
	public void ofDuplicateCheckTest() {
		// given
		List<Integer> notEnoughNumbers = Arrays.asList(1, 2, 3, 4, 5);
		List<Integer> duplicateNumbers = Arrays.asList(1, 2, 3, 4, 5, 5);

		// when, then
		assertThatThrownBy(() -> LottoTicket.of(notEnoughNumbers))
			.isInstanceOf(IllegalArgumentException.class);
		assertThatThrownBy(() -> LottoTicket.of(duplicateNumbers))
			.isInstanceOf(IllegalArgumentException.class);
	}

}
