package lotto.domain.wrapper;

import java.math.BigDecimal;
import java.util.List;

public final class AnalysisResult {
	private final HitsByRank hitsByRank;
	private final BigDecimal profitPercent;
	private final List<LottoTicket> holdings;

	public AnalysisResult(HitsByRank hitsByRank, BigDecimal profitPercent, List<LottoTicket> holdings) {
		this.hitsByRank = hitsByRank;
		this.profitPercent = profitPercent;
		this.holdings = holdings;
	}

	public BigDecimal getProfitPercent() {
		return this.profitPercent;
	}

	public HitsByRank getHitsByRank() {
		return this.hitsByRank;
	}
}
