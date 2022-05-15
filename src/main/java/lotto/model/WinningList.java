package lotto.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class WinningList {
	private Map<WinningMoney, Integer> winningList;

	public WinningList() {
		winningList = new LinkedHashMap<>();
		initWinningList();
	}

	public WinningList(Lottos lottos, LottoNumbers winningLottoNumbers) {
		this();
		match(lottos, winningLottoNumbers);
	}

	public Map<WinningMoney, Integer> getWinningList() {
		return this.winningList;
	}

	private void initWinningList() {
		for (WinningMoney winningMoney : WinningMoney.values()) {
			winningList.put(winningMoney, 0);
		}
	}

	private void match(Lottos lottos, LottoNumbers winningLottoNumbers) {
		for (LottoNumbers lottoNumbers : lottos.getLottos()) {
			int count = winningLottoNumbers.countEqualsLottoNumber(lottoNumbers);
			increase(WinningMoney.find(count));
		}
	}

	private void increase(WinningMoney winningMoney) {
		winningList.put(winningMoney, winningList.get(winningMoney) + 1);
	}

}
