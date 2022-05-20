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
	private static final Random random = new Random();

	public Lottos buyManualLottos(UserMoney userMoney, Lottos lottos) {
		validationCanNotBuyLotto(userMoney, lottos.size());
		userMoney.buyLotto(lottos.size() * LOTTO_PRICE);
		return lottos;
	}

	public Lottos buyAutoLottos(UserMoney userMoney) {
		List<LottoNumbers> lottos = new ArrayList<>();
		for (int i = 0; i < canBuyLottoCount(userMoney); ++i) {
			lottos.add(randomLottoNumbers());
		}

		userMoney.buyLotto(lottos.size() * LOTTO_PRICE);
		return new Lottos(lottos);
	}

	private void validationCanNotBuyLotto(UserMoney userMoney, int pieceCount) {
		if (!isCanBuyLotto(userMoney, pieceCount)) {
			throw new IllegalArgumentException("로또를 구매할 수 있는 수량을 초과했습니다. 구입가능 로또의 갯수 : " + canBuyLottoCount(userMoney));
		}
	}

	public boolean isCanBuyLotto(UserMoney userMoney, int pieceCount) {
		return canBuyLottoCount(userMoney) >= pieceCount;
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
