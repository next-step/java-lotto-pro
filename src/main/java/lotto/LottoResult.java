package lotto;

import java.util.ArrayList;
import java.util.List;

import lotto.model.LottoNumbers;
import lotto.model.Lottos;
import lotto.model.WinningList;
import lotto.model.WinningLotto;

public class LottoResult {
	private final Lottos lottos;
	private final WinningList winningList;

	public LottoResult(WinningLotto winningLotto, Lottos... lottosList) {
		List<LottoNumbers> lottos = new ArrayList<>();
		for (Lottos lottosData : lottosList) {
			lottos.addAll(lottosData.getLottos());
		}

		this.lottos = new Lottos(lottos);
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
