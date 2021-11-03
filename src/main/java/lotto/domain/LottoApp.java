package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoApp {

	private static final int LOTTO_PRICE = 1000;

	public int getLottoCountByMoney(int money) {
		return money / LOTTO_PRICE;
	}

	public List<LottoNumber> getLottoNumbersByCount(int count) {
		List<LottoNumber> lottoList = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			lottoList.add(LottoNumberGenerator.generate());
		}
		return lottoList;
	}

	public double getProfit(int money, LottoPrize lottoPrize) {
		int prize = lottoPrize.getPrize();
		double profit = (double)prize / money;
		return Math.floor(profit * 100) / 100D;
	}

	public LottoPrize calculatePoint(LottoNumber answerNumbers, List<LottoNumber> numbers) {
		return new LottoPrize(answerNumbers, numbers);
	}

}
