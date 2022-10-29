package lotto;

import static lotto.view.LottoWinPrize.ONE_MATCHES;
import static lotto.view.LottoWinPrize.SIX_MATCHES;
import static lotto.view.LottoWinPrize.ZERO_MATCHES;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.stream.Stream;

import org.assertj.core.util.Lists;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import lotto.domain.LottoWinPrizes;

class LottoTicketsTest {

	@ParameterizedTest
	@MethodSource("로또_티켓_입력")
	void 여러장의_로또_티켓과_한장을_비교하여_로또_당첨_결과들을_알_수_있다(LottoTickets 로또_티켓_여러장, LottoTicket 비교_로또티켓, LottoWinPrizes 에상_당첨_결과) {

		LottoWinPrizes 당첨_결과 = 로또_티켓_여러장.match(비교_로또티켓);

		assertThat(당첨_결과).isEqualTo(에상_당첨_결과);
	}

	private static Stream<Arguments> 로또_티켓_입력() {
		return Stream.of(
			Arguments.of(
				LottoTickets.of(
					Lists.newArrayList(
						LottoTicket.of(10, 11, 12, 13, 14, 15),
						LottoTicket.of(1, 10, 11, 12, 13, 14),
						LottoTicket.of(1, 2, 3, 4, 5, 6))),
				LottoTicket.of(1, 2, 3, 4, 5, 6),
				LottoWinPrizes.of(ONE_MATCHES, ZERO_MATCHES, SIX_MATCHES)
			)
		);
	}

}
