package lotto2.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoStaticsTest {

	@Test
	@DisplayName("로또 티켓들과 당첨번호가 주어지면, 순위집계를 반환한다")
	public void calculateRankCountTest() {
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

		// when
		RankCounts rankCounts = LottoStatics.calculateRankCount(
			lottoTickets,
			winningLotto);

		// then
		assertThat(rankCounts.get(Rank.FIRST.name())).isEqualTo(1);
		assertThat(rankCounts.get(Rank.SECOND.name())).isEqualTo(1);
		assertThat(rankCounts.get(Rank.THIRD.name())).isEqualTo(1);
		assertThat(rankCounts.get(Rank.FOURTH.name())).isEqualTo(1);
		assertThat(rankCounts.get(Rank.FIFTH.name())).isEqualTo(2);
	}

	@Test
	@DisplayName("순위집계가 주어지면 상금을 반환해야한다")
	public void calculateTotalPrizeTest() {
		// given
		Map<Rank, Integer> rankAndCounts = new HashMap<>();
		rankAndCounts.put(Rank.FIRST, 0);
		rankAndCounts.put(Rank.FIFTH, 1);
		RankCounts rankCounts = RankCounts.of(rankAndCounts);

		// when
		int totalPrize = LottoStatics.calculateTotalPrize(rankCounts);

		// then
		assertThat(totalPrize).isEqualTo(5000);
	}

	@Test
	@DisplayName("순위집계와 구매금액이 주어지면, 수익률을 계산한다")
	public void calculateProfitTest() {
		// given
		Map<Rank, Integer> rankAndCounts = new HashMap<>();
		rankAndCounts.put(Rank.FIRST, 0);
		rankAndCounts.put(Rank.FIFTH, 1);
		RankCounts rankCounts = RankCounts.of(rankAndCounts);
		Money money = Money.of(10000);

		// when
		double profit = LottoStatics.calculateProfit(rankCounts, money);

		// then
		assertThat(profit).isEqualTo(0.5D);
	}
}
