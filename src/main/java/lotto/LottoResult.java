package lotto;

import lotto.model.Lottos;
import lotto.model.WinningList;
import lotto.model.WinningLotto;

public class LottoResult {
	private final Lottos lottos;
	private final WinningList winningList;

	public LottoResult(WinningLotto winningLotto, Lottos lottos) {
		this.lottos = lottos;
		this.winningList = new WinningList(this.lottos, winningLotto);
	}

	public WinningList winningList() {
		return winningList;
	}

	public double profitRate(int lottoPrice) {
		return (double) totalWinningMoney(winningList) / (lottos.getLottos().size() * lottoPrice);
	}

	private long totalWinningMoney(WinningList winningList) {

		return winningList.getWinningList().entrySet().stream()
				.mapToLong(entry -> entry.getKey().winningMoney(entry.getValue())).sum();
	}
}
