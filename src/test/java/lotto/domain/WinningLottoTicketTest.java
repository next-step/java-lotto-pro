package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Set;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import lotto.exception.InvalidLottoNumberException;

@DisplayName("당첨 티켓 테스트")
class WinningLottoTicketTest {

	@ParameterizedTest
	@MethodSource("provideWinningLottoTicket")
	@DisplayName("당첨 티켓과 구매 티켓을 비교하여 순위 반환")
	void getMatchCountTest(Set<Integer> lottoNumbers, int bonusNumber, Rank expected) {
		WinningLottoTicket winningTicket =
			WinningLottoTicket.from(LottoNumbers.from(lottoNumbers), LottoNumber.from(bonusNumber));
		LottoTicket purchaseTicket = LottoTicket.from(new TestGenerateStrategy());
		Rank rank = winningTicket.rank(purchaseTicket);
		assertThat(rank).isEqualTo(expected);
	}

	private static Stream<Arguments> provideWinningLottoTicket() {
		return Stream.of(
			Arguments.of(Set.of(1, 2, 3, 4, 5, 6), 7, Rank.FIRST),
			Arguments.of(Set.of(1, 2, 3, 4, 5, 7), 6, Rank.SECOND),
			Arguments.of(Set.of(1, 2, 3, 4, 5, 8), 7, Rank.THIRD),
			Arguments.of(Set.of(1, 2, 3, 4, 8, 7), 10, Rank.FOURTH),
			Arguments.of(Set.of(1, 2, 3, 9, 8, 7), 10, Rank.FIFTH),
			Arguments.of(Set.of(1, 2, 11, 9, 8, 7), 10, Rank.LOSE)
		);
	}

	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3, 4, 5, 6})
	@DisplayName("당첨 번호와 보너스 번호가 중복 시 InvalidLottoNumberException 발생")
	void invalidLottoNumberExceptionTest(int bonusNumber) {
		LottoNumbers winningNumbers = LottoNumbers.from(Set.of(1, 2, 3, 4, 5, 6));
		LottoNumber bonusLottoNumber = LottoNumber.from(bonusNumber);
		assertThatThrownBy(() ->
			WinningLottoTicket.from(winningNumbers, bonusLottoNumber))
			.isInstanceOf(InvalidLottoNumberException.class)
			.hasMessageContaining("중복");
	}
}