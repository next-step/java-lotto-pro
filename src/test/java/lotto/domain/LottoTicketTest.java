package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

	@ParameterizedTest
	@CsvSource(value = {"1,true", "6,true", "9,false"})
	@DisplayName("로또 번호가 포함되어 있는지 체크할 수 있다")
	public void containsTest(int number, boolean expected) {
		// given
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
		LottoNumber lottoNumber = LottoNumber.of(number);
		LottoTicket ticket = LottoTicket.of(numbers);

		// when
		boolean result = ticket.contains(lottoNumber);

		// then
		assertThat(result).isEqualTo(expected);
	}

	@Test
	@DisplayName("다른 로또티켓이 주어지면 같은 번호 갯수를 반환해야 한다")
	public void getMatchCountTest() {
		// given
		int expected = 5;
		LottoTicket lottoTicket = LottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 6));
		LottoTicket other = LottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 10));

		// when
		int matchCnt = lottoTicket.getMatchCount(other);

		// then
		assertThat(matchCnt).isEqualTo(expected);
	}
}
