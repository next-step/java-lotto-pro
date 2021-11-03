package lotto.view;

import java.util.List;

import lotto.domain.LottoNumber;
import lotto.domain.LottoPrize;

public class ResultView {

	public static void showLottoNumbers(int count, List<LottoNumber> numbersList) {
		System.out.println(count + "개를 구매했습니다.");
		StringBuilder result = new StringBuilder();

		for (LottoNumber numbers : numbersList) {
			result.append("[ ");
			result.append(numbers.toString());
			result.append(" ]\n");
		}
		System.out.println(result);
	}

	public static void showPrize(LottoPrize vo, double profit) {
		String result = "\n당첨통계\n";
		result += "---------\n";
		result += "3개 일치 (5000원)- " + vo.getCnt4St() + "개\n";
		result += "4개 일치 (50000원)- " + vo.getCnt3St() + "개\n";
		result += "5개 일치 (1500000원)- " + vo.getCnt2St() + "개\n";
		result += "6개 일치 (2000000000원)- " + vo.getCnt1St() + "개\n";
		System.out.println(result);
		System.out.printf("총 수익률은 %.2f입니다\n", profit);
	}

}
