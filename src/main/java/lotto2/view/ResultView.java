package lotto2.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lotto2.domain.LottoNumber;
import lotto2.domain.LottoTicket;
import lotto2.domain.LottoTickets;
import lotto2.domain.Rank;

public class ResultView {

	public static void showLottoNumbers(int manualCount, int autoCount, LottoTickets tickets) {
		System.out.printf("\n수동으로 %d 장, 자동으로 %d 개를 구매했습니다.\n"
			, manualCount, autoCount);
		StringBuilder result = new StringBuilder();
		for (LottoTicket ticket : tickets) {
			result.append("[ ");
			result.append(showLottoNumber(ticket));
			result.append(" ]\n");
		}
		System.out.println(result);
	}

	private static String showLottoNumber(LottoTicket ticket) {
		List<String> elements = new ArrayList<>();
		for (LottoNumber number : ticket.getNumbers()) {
			elements.add(String.valueOf(number.toInt()));
		}
		return String.join(",", elements);
	}

	public static void showPrize(Map<String, Integer> rankCounts, double profit) {
		String result = "\n당첨통계\n";
		result += "---------\n";
		result += "3개 일치 (5000원)- " + rankCounts.get(Rank.FIFTH.name()) + "개\n";
		result += "4개 일치 (50000원)- " + rankCounts.get(Rank.FOURTH.name()) + "개\n";
		result += "5개 일치 (1500000원)- " + rankCounts.get(Rank.THIRD.name()) + "개\n";
		result += "5개 일치, 보너스볼 일치 (3000000원)- " + rankCounts.get(Rank.SECOND.name()) + "개\n";
		result += "6개 일치 (2000000000원)- " + rankCounts.get(Rank.FIRST.name()) + "개\n";
		System.out.println(result);
		System.out.printf("총 수익률은 %.2f입니다\n", profit);
	}
}
