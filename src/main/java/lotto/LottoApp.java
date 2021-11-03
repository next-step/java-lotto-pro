package lotto;

import java.util.List;

public class LottoApp {

	public static void main(String[] args) {
		LottoDomain lottoDomain = new LottoDomain();

		int money = InputView.getMoney();
		int lottoCount = lottoDomain.getLottoCountByMoney(money);
		List<List<Integer>> numbers = lottoDomain.getLottoNumbersByCount(lottoCount);
		OutputView.showLottoNumbers(lottoCount, numbers);

		List<Integer> answer = InputView.getLottoNumbers();
		MatchPoint points = lottoDomain.calculatePoint(answer, numbers);
		double profit = lottoDomain.getProfit(money, points);
		OutputView.showPrize(points, profit);
	}

}
