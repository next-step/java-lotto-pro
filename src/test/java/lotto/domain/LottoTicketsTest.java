package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTicketsTest {

	@Test
	@DisplayName("N개의 로또티켓들로 생성되어야 한다")
	public void ofTest() {
		// given
		LottoTicket ticket1 = LottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 6));
		LottoTicket ticket2 = LottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 6));
		LottoTicket ticket3 = LottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 7));
		List<LottoTicket> ticketList = Arrays.asList(ticket1, ticket2, ticket3);

		// when
		LottoTickets lottoTickets = LottoTickets.of(ticketList);

		// then
		assertThat(lottoTickets).isEqualTo(LottoTickets.of(ticketList));
	}

	@Test
	@DisplayName("로또 티켓들의 갯수가 맞는지 확인할 수 있어야 한다")
	public void isEqualSizeTest() {
		// given
		LottoTicket ticket1 = LottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 6));
		LottoTicket ticket2 = LottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 6));
		LottoTicket ticket3 = LottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 7));
		List<LottoTicket> ticketList = Arrays.asList(ticket1, ticket2, ticket3);
		PositiveNumber size = PositiveNumber.of(ticketList.size());

		// when
		LottoTickets lottoTickets = LottoTickets.of(ticketList);

		// then
		assertThat(lottoTickets.isEqualSize(size)).isTrue();
	}

	@Test
	@DisplayName("당첨번호가 주어지면 당첨갯수를 계산해야 한다")
	public void countRanksTest() {
		// given
		LottoTicket ticket1 = LottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 6));
		LottoTicket ticket2 = LottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 45));
		LottoTicket ticket3 = LottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 10));
		List<LottoTicket> ticketList = Arrays.asList(ticket1, ticket2, ticket3);
		LottoTickets lottoTickets = LottoTickets.of(ticketList);
		LottoTicket lottoNumbers = LottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 6));
		LottoNumber bonusNumber = LottoNumber.of(45);
		WinningLotto winningLotto = WinningLotto.of(lottoNumbers, bonusNumber);

		// when
		RankCounts rankCounts = lottoTickets.countRanks(winningLotto);

		// then
		assertThat(rankCounts.get(Rank.FIRST.name())).isEqualTo(1);
		assertThat(rankCounts.get(Rank.SECOND.name())).isEqualTo(1);
		assertThat(rankCounts.get(Rank.THIRD.name())).isEqualTo(1);
		assertThat(rankCounts.get(Rank.FOURTH.name())).isEqualTo(0);
		assertThat(rankCounts.get(Rank.FIFTH.name())).isEqualTo(0);
	}

}
