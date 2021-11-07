package lotto.domain;

import java.util.EnumMap;

public class Statistics {
	private static final int NOT_CALCULATED_YET = -1;

	private final Lotto winningLotto;
	private final Lottos userLottos;

	private int purchaseAmount;
	private int totalPrize;
	private EnumMap<Rank, Integer> winningResults;

	public Statistics(Lotto winningLotto, Lottos userLottos) {
		this.winningLotto = winningLotto;
		this.userLottos = userLottos;
		this.purchaseAmount = NOT_CALCULATED_YET;
		this.totalPrize = NOT_CALCULATED_YET;
		this.winningResults = null;
	}

	public float earningRate() {
		if (purchaseAmount == NOT_CALCULATED_YET) {
			purchaseAmount = calcPurchaseAmount();
		}

		if (totalPrize == NOT_CALCULATED_YET) {
			totalPrize = calcTotalPrize();
		}

		return totalPrize / (float)purchaseAmount;
	}

	private int calcPurchaseAmount() {
		return userLottos.size() * Common.LOTTO_PRICE;
	}

	public EnumMap<Rank, Integer> winningCounts() {
		if (winningResults == null) {
			initWinningCounts();
		}

		return winningResults;
	}

	private void initWinningCounts() {
		winningResults = new EnumMap<>(Rank.class);

		for (Rank rank : Rank.values()) {
			winningResults.put(rank, 0);
		}

		for (Lotto lotto : userLottos.lottos()) {
			int matchCount = winningLotto.countMatch(lotto);
			Rank rank = Rank.from(matchCount);
			winningResults.put(rank, winningResults.getOrDefault(rank, 0) + 1);
		}
	}

	private int calcTotalPrize() {
		totalPrize = 0;

		for (Lotto lotto : userLottos.lottos()) {
			int matchCount = winningLotto.countMatch(lotto);
			Rank rank = Rank.from(matchCount);
			totalPrize += rank.prizeMoney();
		}

		return totalPrize;
	}
}
