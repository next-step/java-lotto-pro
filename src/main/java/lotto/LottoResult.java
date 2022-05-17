package lotto;

import lotto.model.LottoNumber;
import lotto.model.LottoNumbers;
import lotto.model.Lottos;
import lotto.model.WinningList;

public class LottoResult {
	private final Lottos lottos;
	private final WinningList winningList;

	public LottoResult(Lottos lottos, LottoNumbers lastWinningLotto, String bonusLottoNumber) {
		validationBonus(lastWinningLotto, bonusLottoNumber);
		this.lottos = lottos;
		this.winningList = new WinningList(lottos, lastWinningLotto, bonusLottoNumber);
	}

	private void validationBonus(LottoNumbers lastWinningLotto, String bonusLottoNumber) {
		if (lastWinningLotto.contains(new LottoNumber(bonusLottoNumber))) {
			throw new IllegalArgumentException("입력된 보너스볼 숫자가 이미 로또번호에 포함되어 있습니다.");
		}
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
