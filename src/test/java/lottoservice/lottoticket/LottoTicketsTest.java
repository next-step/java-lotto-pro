package lottoservice.lottoticket;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoTicketsTest {

	@Test
	public void getNumOfTickets_로또_티켓_갯수(){
		List<LottoTicket> tickets = Arrays.asList(new LottoTicket(), new LottoTicket());
		LottoTickets lottoTickets = new LottoTickets(tickets);
		Assertions.assertThat(lottoTickets.getNumOfTickets()).isEqualTo(tickets.size());
	}
}