package lotto;

import lotto.model.LottoNumbers;
import lotto.model.Lottos;
import lotto.model.WinningList;

public class LottoResult {
	private Lottos lottos;
	private LottoNumbers lastWinningLotto;

	public LottoResult(Lottos lottos, LottoNumbers lastWinningLotto) {
		this.lottos = lottos;
		this.lastWinningLotto = lastWinningLotto;
	}

	public WinningList winningList() {
		return new WinningList(lottos, lastWinningLotto);
	}

	public double profitRate(WinningList winningList, int lottoPrice) {
		return (double) totalWinningMoney(winningList) / (lottos.getLottos().size() * lottoPrice);
	}

	private long totalWinningMoney(WinningList winningList) {
		return winningList.getWinningList().entrySet().stream()
				.mapToLong(entry -> entry.getKey().winningMoney(entry.getValue())).sum();
	}
}
