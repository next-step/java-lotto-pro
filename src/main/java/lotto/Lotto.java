package lotto;

import java.util.ArrayList;
import java.util.List;

import lotto.model.LottoNumber;
import lotto.model.LottoNumbers;
import lotto.model.UserMoney;
import lotto.model.WinningList;

public class Lotto {
	private static final String LOTTO_INPUT_LIST_REGEX = ",";
	private LottoResult lottoResult;

	public Lotto() {
		lottoResult = new LottoResult();
	}

	public WinningList winningList(String lastWinLotto) {
		List<LottoNumber> lottoNumbers = lastWinLottoNumbers(lastWinLotto);
		return lottoResult.winningList(new LottoNumbers(lottoNumbers));
	}

	public double printProfitRate(WinningList winningList, UserMoney userMoney) {
		return lottoResult.profitRate(winningList, userMoney);
	}

	public List<LottoNumbers> buyAutoLotto(UserMoney userMoney) {
		return lottoResult.buyAutoLottos(userMoney);
	}

	private List<LottoNumber> lastWinLottoNumbers(String lastLottoNumbers) {
		List<LottoNumber> lottoNumbers = new ArrayList<>();
		for (String lottoNumber : lastLottoNumbers.split(LOTTO_INPUT_LIST_REGEX)) {
			lottoNumbers.add(new LottoNumber(lottoNumber));
		}
		return lottoNumbers;
	}
}
