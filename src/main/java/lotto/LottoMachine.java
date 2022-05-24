package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import lotto.model.LottoNumber;
import lotto.model.LottoNumbers;
import lotto.model.Lottos;
import util.NumberUtil;

public class LottoMachine {
	private static final int LOTTO_PRICE = 1000;
	private static final Random random = new Random();

	public Lottos buyLottos(int userCoin, List<LottoNumbers> lottos) {
		validationCanNotBuyLotto(userCoin, lottos.size());
		lottos.addAll(buyAutoLottos(userCoin, lottos));
		return new Lottos(lottos);
	}

	private List<LottoNumbers> buyAutoLottos(int userCoin, List<LottoNumbers> manualLottos) {
		List<LottoNumbers> lottos = new ArrayList<>();
		for (int i = 0; i < userCoin - manualLottos.size(); ++i) {
			lottos.add(randomLottoNumbers());
		}

		return lottos;
	}

	public int tradeCoin(String userMoney) {
		validationNumber(userMoney);
		validationMinMoney(Integer.parseInt(userMoney));
		return Integer.parseInt(userMoney) / LOTTO_PRICE;
	}

	public void isCanBuyLotto(int userCoin, String pieceCount) {
		validationNumber(pieceCount);
		validationCanNotBuyLotto(userCoin, Integer.parseInt(pieceCount));
	}

	private void validationCanNotBuyLotto(int userCoin, int pieceCount) {
		if (userCoin < pieceCount) {
			throw new IllegalArgumentException("로또를 구매할 수 있는 수량을 초과했습니다. 구매할 수 있는 로뜨의 갯수 : " + userCoin);
		}
	}

	private void validationNumber(String pieceCount) {
		if (!NumberUtil.isNumber(pieceCount)) {
			throw new IllegalArgumentException(String.format("nubmer: %d 숫자가 아닙니다.", pieceCount));
		}
	}

	private void validationMinMoney(int userMoney) {
		if (userMoney < LOTTO_PRICE) {
			throw new IllegalArgumentException(
					String.format("로또는 %d원이므로 최소 %d원 이상 입력해야합니다.", LOTTO_PRICE, LOTTO_PRICE));
		}
	}

	public int lottoPrice() {
		return LOTTO_PRICE;
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
