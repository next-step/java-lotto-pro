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
	@DisplayName("로또 티켓을 추가할 수 있어야 한다")
	public void addTest() {
		// given
		LottoTickets tickets = LottoTickets.of();
		LottoTicket ticket1 = LottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 6));
		LottoTicket ticket2 = LottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 6));
		LottoTicket ticket3 = LottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 7));
		List<LottoTicket> ticketList = Arrays.asList(ticket1, ticket2, ticket3);

		// when
		tickets.add(ticket1);
		tickets.add(ticket2);
		tickets.add(ticket3);

		// then
		assertThat(tickets).isEqualTo(LottoTickets.of(ticketList));

	}

}
