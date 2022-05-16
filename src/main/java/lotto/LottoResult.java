package lotto;

import lotto.model.LottoNumbers;
import lotto.model.Lottos;
import lotto.model.WinningList;

public class LottoResult {
	private final Lottos lottos;
	private final WinningList winningList;

	public LottoResult(Lottos lottos, LottoNumbers lastWinningLotto, String bonusLottoNumber) {
		this.lottos = lottos;
		this.winningList = new WinningList(lottos, lastWinningLotto, bonusLottoNumber);
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
