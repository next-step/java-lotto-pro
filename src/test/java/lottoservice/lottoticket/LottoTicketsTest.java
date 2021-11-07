package lottoservice.lottoticket;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import lottoservice.lottonumber.LottoArrangeManipulator;
import lottoservice.lottonumber.LottoNumbersMaker;

class LottoTicketsTest {

	@Test
	public void getNumOfTickets_로또_티켓_생성() {
		LottoNumbersMaker lottoNumbersMaker = new LottoNumbersMaker(new LottoArrangeManipulator());
		List<LottoTicket> tickets = Arrays.asList(
			new LottoTicket(lottoNumbersMaker.makeLottoNumbers()),
			new LottoTicket(lottoNumbersMaker.makeLottoNumbers()));
		LottoTickets lottoTickets = new LottoTickets(tickets);

		assertThat(lottoTickets.getNumOfTickets()).isEqualTo(tickets.size());
		tickets.stream().forEach(it -> assertThat(lottoTickets.hasTicket(it)).isTrue());
	}
}