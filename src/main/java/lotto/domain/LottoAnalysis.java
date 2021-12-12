package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import lotto.domain.wrapper.AnalysisResult;
import lotto.domain.wrapper.HitsByRank;
import lotto.domain.wrapper.LottoNumber;
import lotto.domain.wrapper.LottoTicket;
import lotto.domain.wrapper.Money;
import lotto.domain.wrapper.Rank;

public class LottoAnalysis {
	private static final String MESSAGE_WRONG_BONUS_NUMBER = "보너스 볼을 다시 입력해 주세요.";

	private final LottoTicket lastWinningTicket;
	private final LottoNumber bonus;

	public LottoAnalysis(LottoTicket lastWinningTicket, LottoNumber bonus) {
		this.lastWinningTicket = lastWinningTicket;
		this.bonus = validatedBonus(bonus);
	}

	public boolean hasLastWinningTicket() {
		return this.lastWinningTicket != null;
	}

	public AnalysisResult analysis(Money investment, List<LottoTicket> holdings) {
		HitsByRank hitsByRank = new HitsByRank();
		for (LottoTicket ticket : holdings) {
			int matchedNumberCount = ticket.countMatchNumbers(this.lastWinningTicket);
			hitsByRank.hit(Rank.valueOf(matchedNumberCount, ticket.getNumbers().contains(bonus)));
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

	public LottoNumber validatedBonus(LottoNumber bonus) {
		try {
			return validatedBonusNumber(bonus);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(MESSAGE_WRONG_BONUS_NUMBER);
		}
	}

	public LottoNumber validatedBonusNumber(LottoNumber bonus) {
		if (!LottoTicket.getDefaultNumbers().contains(bonus) || this.lastWinningTicket.getNumbers().contains(bonus)) {
			throw new IllegalArgumentException(MESSAGE_WRONG_BONUS_NUMBER);
		}
		return bonus;
	}
}
