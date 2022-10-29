package lotto;

import money.Money;

public class LottoWinResult {

	public static ProfitMargin computeProfitMargin(Money purchaseAmount, LottoMatchCounts matchCounts) {
		Money totalProfits = matchCounts.getTotalProfits();
		return ProfitMargin.valueOf(totalProfits.divideBy(purchaseAmount));
	}

}
