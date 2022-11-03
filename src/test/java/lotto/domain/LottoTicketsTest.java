package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("로또 티켓 collection 테스트")
class LottoTicketsTest {

	@Test
	@DisplayName("로또 티켓 collection 생성")
	void createLottoTicketsTest() {
		LottoTicket lottoTicket = LottoTicket.from(new TestGenerateStrategy());
		LottoTickets lottoTickets = LottoTickets.from(List.of(lottoTicket));
		assertThat(lottoTickets).isInstanceOf(LottoTickets.class);
	}

	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
	@DisplayName("로또 티켓 수 반환")
	void getLottoTicketsSizeTest(int count) {
		LottoTickets lottoTickets = IntStream.range(0, count)
			.mapToObj(i -> LottoTicket.from(new TestGenerateStrategy()))
			.collect(Collectors.collectingAndThen(Collectors.toList(), LottoTickets::from));
		assertThat(lottoTickets.count()).isEqualTo(count);
	}

	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
	@DisplayName("로또 티켓 수 만큼의 Rank 개수를 담은 Ranks 생성")
	void getRanksTest(int count) {
		// given
		LottoTickets lottoTickets = IntStream.range(0, count)
			.mapToObj(i -> LottoTicket.from(new TestGenerateStrategy()))
			.collect(Collectors.collectingAndThen(Collectors.toList(), LottoTickets::from));

		// when
		WinningLottoTicket winningLottoTicket =
			WinningLottoTicket.from(new TestGenerateStrategy().generate(), LottoNumber.from(10));
		Ranks ranks = lottoTickets.ranks(winningLottoTicket);

		// then
		assertThat(ranks.size()).isEqualTo(count);
	}

}