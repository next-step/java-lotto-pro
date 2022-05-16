package lotto.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class WinningList {
	private static final int BOUNS_CHECK_NUMBER = 5;
	private final Map<WinningMoney, Integer> winningList;

	public WinningList() {
		winningList = new LinkedHashMap<>();
		initWinningList();
	}

	public WinningList(Lottos lottos, LottoNumbers winningLottoNumbers, String bonusLottoNumber) {
		this();
		match(lottos, winningLottoNumbers, bonusLottoNumber);
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
			int count = winningLottoNumbers.countEqualsLottoNumber(lottoNumbers);
			increase(find(lottoNumbers, count, bonusLottoNumber));
		}
	}

	private WinningMoney find(LottoNumbers lottoNumbers, int count, String bonusLottoNumber) {
		if (isSecondPlace(lottoNumbers, count, bonusLottoNumber)) {
			return WinningMoney.SECOND;
		}
		return WinningMoney.find(count);
	}

	private boolean isSecondPlace(LottoNumbers lottoNumbers, int count, String bonusLottoNumber) {
		if (count != BOUNS_CHECK_NUMBER) {
			return false;
		}
		return lottoNumbers.getLottoNumbers().contains(new LottoNumber(bonusLottoNumber));
	}

	private void increase(WinningMoney winningMoney) {
		winningList.put(winningMoney, winningList.get(winningMoney) + 1);
	}

}
