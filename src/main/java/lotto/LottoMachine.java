package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lotto.model.LottoNumber;
import lotto.model.LottoNumbers;
import lotto.model.Lottos;
import lotto.model.UserMoney;

public class LottoMachine {
	private static final int LOTTO_PRICE = 1000;

	public Lottos buyAutoLottos(UserMoney userMoney) {
		List<LottoNumbers> lottos = new ArrayList<>();
		for (int i = 0; i < canBuyLottoCount(userMoney); ++i) {
			lottos.add(randomLottoNumbers());
		}

		return new Lottos(lottos);
	}

	public int lottoPrice() {
		return LOTTO_PRICE;
	}

	private int canBuyLottoCount(UserMoney userMoney) {
		return userMoney.getMoney() / LOTTO_PRICE;
	}

	private LottoNumbers randomLottoNumbers() {
		List<LottoNumber> lottoNumbers = new ArrayList<>();
		for (int i = LottoNumber.minLottoNumber(); i <= LottoNumber.maxLottoNumber(); ++i) {
			lottoNumbers.add(new LottoNumber(i));
		}
		Collections.shuffle(lottoNumbers);
		return new LottoNumbers(lottoNumbers.subList(0, LottoNumbers.lottoNumbersCount()));
	}
}
