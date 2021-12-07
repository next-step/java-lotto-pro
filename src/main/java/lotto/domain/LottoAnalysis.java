package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import lotto.domain.wrapper.AnalysisResult;
import lotto.domain.wrapper.HitsByRank;
import lotto.domain.wrapper.LottoTicket;
import lotto.domain.wrapper.Money;
import lotto.domain.wrapper.Rank;

public class LottoAnalysis {
	private LottoTicket lastWinningTicket;

	public LottoAnalysis() {
	}

	public void setLastWinningTicket(LottoTicket lottoTicket) {
		this.lastWinningTicket = lottoTicket;
	}

	public boolean hasLastWinningTicket() {
		return lastWinningTicket != null;
	}

	public AnalysisResult analysis(Money investment, List<LottoTicket> holdings) {
		HitsByRank hitsByRank = new HitsByRank();
		for (LottoTicket ticket : holdings) {
			int matchedNumberCount = (int)ticket.getNumbers().stream()
				.filter(this.lastWinningTicket.getNumbers()::contains)
				.count();
			hitsByRank.hit(Rank.valueOf(matchedNumberCount, ticket.getNumbers().contains(lastWinningTicket.getBonus())));
		}
		BigDecimal profitPercent = totalWinnings(hitsByRank).get()
			.subtract(investment.get())
			.divide(investment.get(), RoundingMode.CEILING);
		return new AnalysisResult(hitsByRank, profitPercent, holdings);
	}


	private Money totalWinnings(HitsByRank hitsByRank) {
		int winnings = 0;

		for (Rank rank : hitsByRank.get().keySet()) {
			winnings += rank.getWinningMoney() * hitsByRank.getHitsByRank(rank);
		}
		return new Money(winnings);
	}
}
