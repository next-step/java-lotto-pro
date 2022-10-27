package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Set;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("당첨 티켓 테스트")
class WinningLottoTicketTest {

	@ParameterizedTest
	@MethodSource("provideWinningLottoTicket")
	@DisplayName("당첨 티켓과 구매 티켓의 일치하는 숫자의 개수 반환")
	void getMatchCountTest(Set<Integer> lottoNumbers, int expected) {
		WinningLottoTicket winningTicket = WinningLottoTicket.of(LottoNumbers.of(lottoNumbers));
		LottoTicket purchaseTicket = LottoTicket.of(new TestGenerateStrategy());
		int matchCount = winningTicket.matchCount(purchaseTicket);
		assertThat(matchCount).isEqualTo(expected);
	}

	private static Stream<Arguments> provideWinningLottoTicket() {
		return Stream.of(
			Arguments.of(Set.of(1,2,3,4,5,6), 6),
			Arguments.of(Set.of(1,2,3,4,5,7), 5),
			Arguments.of(Set.of(1,2,3,4,8,7), 4),
			Arguments.of(Set.of(1,2,3,9,8,7), 3),
			Arguments.of(Set.of(1,2,11,9,8,7), 2)
		);
	}
}