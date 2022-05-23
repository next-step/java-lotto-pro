package lotto.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class WinningList {
	private final Map<WinningMoney, Integer> winningList;

	public WinningList() {
		winningList = new LinkedHashMap<>();
		initWinningList();
	}

	public WinningList(Lottos lottos, WinningLotto winningLotto) {
		this();
		match(lottos, winningLotto.getLottoNumbers(), winningLotto.getBonusLottoNumber());
	}

	public Map<WinningMoney, Integer> getWinningList() {
		return this.winningList;
	}

	private void initWinningList() {
		for (WinningMoney winningMoney : WinningMoney.values()) {
			winningList.put(winningMoney, 0);
		}
	}

	private void match(Lottos lottos, LottoNumbers winningLottoNumbers, String bonusLottoNumber) {
		for (LottoNumbers lottoNumbers : lottos.getLottos()) {
			int matchCount = winningLottoNumbers.countEqualsLottoNumber(lottoNumbers);
			increase(find(lottoNumbers, matchCount, bonusLottoNumber));
		}
	}

	private WinningMoney find(LottoNumbers lottoNumbers, int matchCount, String bonusLottoNumber) {
		if (isSecondPlace(lottoNumbers, matchCount, bonusLottoNumber)) {
			return WinningMoney.SECOND;
		}
		return WinningMoney.find(matchCount);
	}

	private boolean isSecondPlace(LottoNumbers lottoNumbers, int matchCount, String bonusLottoNumber) {
		if (matchCount != WinningMoney.SECOND.getMatchCount()) {
			return false;
		}
		return lottoNumbers.contains(new LottoNumber(bonusLottoNumber));
	}

	private void increase(WinningMoney winningMoney) {
		winningList.put(winningMoney, winningList.get(winningMoney) + 1);
	}
}
