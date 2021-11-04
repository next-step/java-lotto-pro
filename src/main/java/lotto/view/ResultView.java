package lotto.view;

import java.util.ArrayList;
import java.util.List;

import lotto.domain.LottoNumber;
import lotto.domain.LottoRanks;

public class ResultView {

	public static void showLottoNumbers(int count, List<LottoNumber> numbersList) {
		System.out.println(count + "개를 구매했습니다.");
		StringBuilder result = new StringBuilder();

		for (LottoNumber lottoNumber : numbersList) {
			result.append("[ ");
			result.append(showLottoNumber(lottoNumber));
			result.append(" ]\n");
		}
		System.out.println(result);
	}

	public static void showPrize(LottoRanks ranks, double profit) {
		String result = "\n당첨통계\n";
		result += "---------\n";
		result += "3개 일치 (5000원)- " + ranks.getFourthCnt() + "개\n";
		result += "4개 일치 (50000원)- " + ranks.getThirdCnt() + "개\n";
		result += "5개 일치 (1500000원)- " + ranks.getSecondCnt() + "개\n";
		result += "6개 일치 (2000000000원)- " + ranks.getFirstCnt() + "개\n";
		System.out.println(result);
		System.out.printf("총 수익률은 %.2f입니다\n", profit);
	}

	public static String showLottoNumber(LottoNumber lottoNumber) {
		List<String> elements = new ArrayList<>();
		for (int number : lottoNumber.getNumbers()) {
			elements.add(String.valueOf(number));
		}
		return String.join(",", elements);
	}

}
