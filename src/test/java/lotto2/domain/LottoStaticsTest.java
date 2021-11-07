package lotto2.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoStaticsTest {

	// TODO: given 줄이기
	@Test
	@DisplayName("로또티켓과 당첨번호를 입력받아서 생성한다")
	public void ofTest() {
		// given
		List<LottoTicket> ticketList = Arrays.asList(
			LottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 6)),
			LottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 45)),
			LottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 10)),
			LottoTicket.of(Arrays.asList(1, 2, 3, 4, 10, 11)),
			LottoTicket.of(Arrays.asList(1, 2, 3, 10, 11, 12)),
			LottoTicket.of(Arrays.asList(1, 2, 3, 10, 11, 12)),
			LottoTicket.of(Arrays.asList(1, 2, 10, 11, 12, 13)),
			LottoTicket.of(Arrays.asList(1, 2, 10, 11, 12, 13))
		);
		LottoTickets lottoTickets = LottoTickets.of(ticketList);
		WinningLotto winningLotto = WinningLotto.of(
			LottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 6)),
			LottoNumber.of(45)
		);
		Money money = Money.of(13000);

		// when
		LottoStatics statics = LottoStatics.of(lottoTickets, winningLotto, money);

		// then
		assertThat(statics)
			.isEqualTo(LottoStatics.of(lottoTickets, winningLotto, money));
		assertThat(statics.getProfit()).isEqualTo(156273.84D);
		assertThat(statics.getCount(Rank.FIRST)).isEqualTo(1);
		assertThat(statics.getCount(Rank.SECOND)).isEqualTo(1);
		assertThat(statics.getCount(Rank.THIRD)).isEqualTo(1);
		assertThat(statics.getCount(Rank.FOURTH)).isEqualTo(1);
		assertThat(statics.getCount(Rank.FIFTH)).isEqualTo(2);
	}

}
