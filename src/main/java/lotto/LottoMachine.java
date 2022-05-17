package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import lotto.model.LottoNumber;
import lotto.model.LottoNumbers;
import lotto.model.Lottos;
import lotto.model.UserMoney;

public class LottoMachine {
	private static final int LOTTO_PRICE = 1000;
	private Random random;

	public LottoMachine() {
		random = new Random();
	}

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
		List<LottoNumber> numberList = new ArrayList<>();
		while (numberList.size() < LottoNumbers.lottoNumbersCount()) {
			LottoNumber randomNumber = new LottoNumber(randomNumber());
			if (!numberList.contains(randomNumber)) {
				numberList.add(randomNumber);
			}
		}
		return numberList;
	}

	private int randomNumber() {
		return random.nextInt(LottoNumber.maxLottoNumber() - LottoNumber.minLottoNumber())
				+ LottoNumber.minLottoNumber();
	}
}
