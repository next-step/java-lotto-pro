package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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
		return new LottoNumbers(randomNumberList());
	}

	private List<LottoNumber> randomNumberList() {
		List<Integer> numberList = new ArrayList<>();
		for (int i = LottoNumber.minLottoNumber(); i <= LottoNumber.maxLottoNumber(); ++i) {
			numberList.add(i);
		}
		Collections.shuffle(numberList);
		return numberList.subList(0, LottoNumbers.lottoNumbersCount()).stream().map(a -> new LottoNumber(a))
				.collect(Collectors.toList());
	}
}
