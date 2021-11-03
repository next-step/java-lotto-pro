package lotto;

import java.util.ArrayList;
import java.util.List;

public class OutputView {

	public static void showLottoNumbers(int count, List<List<Integer>> numbersList) {
		System.out.println(count + "개를 구매했습니다.");
		StringBuilder result = new StringBuilder();

		for (List<Integer> numbers : numbersList) {
			result.append("[ ");
			result.append(String.join(",", parseString(numbers)));
			result.append(" ]\n");
		}
		System.out.println(result);
	}

	public static void showPrize(MatchPoint vo, double profit) {
		String result = "\n당첨통계\n";
		result += "---------\n";
		result += "3개 일치 (5000원)- " + vo.getFourth() + "개\n";
		result += "4개 일치 (50000원)- " + vo.getThird() + "개\n";
		result += "5개 일치 (1500000원)- " + vo.getSecond() + "개\n";
		result += "6개 일치 (2000000000원)- " + vo.getFirst() + "개\n";
		System.out.println(result);
		System.out.printf("총 수익률은 %.2f입니다\n", profit);
	}

	private static List<String> parseString(List<Integer> numbers) {
		List<String> strings = new ArrayList<>();
		for (int number : numbers) {
			strings.add(String.valueOf(number));
		}
		return strings;
	}

}
