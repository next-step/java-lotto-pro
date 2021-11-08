package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoStaticsTest {

	@Test
	@DisplayName("로또티켓들과 당첨번호가 주어지면, 순위집계와 수익률을 반환한다")
	public void calculateTest() {
		// given
		List<LottoTicket> ticketList = Arrays.asList(
			LottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 6)),
			LottoTicket.of(Arrays.asList(6, 7, 8, 9, 10, 45))
		);
		LottoTickets lottoTickets = LottoTickets.of(ticketList);
		WinningLotto winningLotto = WinningLotto.of(
			LottoTicket.of(Arrays.asList(1, 2, 3, 10, 11, 12)),
			LottoNumber.of(45)
		);
		Money money = Money.of(10000);

		// when
		LottoStaticsResult result = LottoStatics.calculate(
			lottoTickets,
			winningLotto, money);

		// then
		RankCounts rankCounts = result.getRankCount();
		assertThat(rankCounts.get(Rank.FIRST.name())).isEqualTo(0);
		assertThat(rankCounts.get(Rank.SECOND.name())).isEqualTo(0);
		assertThat(rankCounts.get(Rank.THIRD.name())).isEqualTo(0);
		assertThat(rankCounts.get(Rank.FOURTH.name())).isEqualTo(0);
		assertThat(rankCounts.get(Rank.FIFTH.name())).isEqualTo(1);

		assertThat(result.getProfit()).isEqualTo(0.5D);

	}
}
