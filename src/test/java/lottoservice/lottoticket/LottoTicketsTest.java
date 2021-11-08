package lottoservice.lottoticket;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import lottoservice.lottonumber.LottoArrangeManipulator;
import lottoservice.lottonumber.LottoNumber;
import lottoservice.lottonumber.LottoNumbersMaker;
import lottoservice.testfactory.TestLottoDataFactory;

class LottoTicketsTest {

	@Test
	public void 로또_티켓_생성() {
		LottoTicket firstTicket = TestLottoDataFactory.getLottoTicket(3,2,15,7,32,17);
		LottoTicket secondTicket = TestLottoDataFactory.getLottoTicket(1,6,37,43,29,15);
		List<LottoTicket> tickets = Arrays.asList(firstTicket,secondTicket);
		LottoTickets lottoTickets = new LottoTickets(tickets);

		assertThat(lottoTickets.getNumOfTickets()).isEqualTo(tickets.size());
		tickets.stream().forEach(it -> assertThat(lottoTickets.hasTicket(it)).isTrue());
	}
}