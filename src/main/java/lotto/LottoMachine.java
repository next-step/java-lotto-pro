package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import lotto.model.LottoNumber;
import lotto.model.LottoNumbers;

public class LottoMachine {
	private static final int LOTTO_PRICE = 1000;
	public static final int MIN_LOTTO_NUMBER = 1;
	public static final int MAX_LOTTO_NUMBER = 45;
	public static final int LOTTO_NUMBERS_COUNT = 6;
	
	private List<LottoNumbers> lottos;
	private model.Number money;
	private int[] winList;

	public LottoMachine(String money) {
		this.money = new model.Number(money);
	}

	public List<LottoNumbers> buyAutoLottos() {
		int times = money.getNumber() / LOTTO_PRICE;

		lottos = new ArrayList<>();
		for (int i = 0; i < times; ++i) {
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

	public int[] winList(LottoNumbers winLottoNumbers) {
		winList = new int[LOTTO_NUMBERS_COUNT + 1];
		Arrays.fill(winList, 0);

		for (LottoNumbers lottoNumbers : lottos) {
			int count = winLottoNumbers.countEqualsLottoNumber(lottoNumbers);
			++winList[count];
		}

		return winList;
	}

	public double profitRate() {
		if (winList == null) {
			return 0;
		}

		int sum = 0;
		for (int i = 1; i < LOTTO_NUMBERS_COUNT + 1; ++i) {
			sum += winList[i] * LottoUtil.WIN_MONEYS[i];
		}

		return (double) sum / money.getNumber();
	}
}
