package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lotto.model.LottoNumber;
import lotto.model.LottoNumbers;
import lotto.model.UserMoney;
import lotto.model.WinningList;
import lotto.model.WinningMoney;

public class LottoResult {
	public static final int MIN_LOTTO_NUMBER = 1;
	public static final int MAX_LOTTO_NUMBER = 45;
	public static final int LOTTO_NUMBERS_COUNT = 6;

	private List<LottoNumbers> lottos;

	public List<LottoNumbers> buyAutoLottos(UserMoney money) {
		if (lottos == null) {
			lottos = new ArrayList<>();
		}
		for (int i = 0; i < money.canBuyLotto(); ++i) {
			lottos.add(randomLottoNumbers());
		}

		return lottos;
	}

	private static LottoNumbers randomLottoNumbers() {
		List<LottoNumber> lottoNumbers = new ArrayList<>();
		for (int i = MIN_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; ++i) {
			lottoNumbers.add(new LottoNumber(i));
		}
		Collections.shuffle(lottoNumbers);
		return new LottoNumbers(lottoNumbers.subList(0, LOTTO_NUMBERS_COUNT));
	}

	public WinningList winningList(LottoNumbers winLottoNumbers) {
		WinningList winningList = new WinningList();

		for (LottoNumbers lottoNumbers : lottos) {
			int count = winLottoNumbers.countEqualsLottoNumber(lottoNumbers);
			winningList.increase(WinningMoney.find(count));
		}
		return winningList;
	}

	public double profitRate(WinningList winningList, UserMoney money) {
		if (winningList == null) {
			return 0;
		}

		return winningList.profitRate(money);
	}
}
