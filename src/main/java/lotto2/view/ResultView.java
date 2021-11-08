package lotto2.view;

import java.util.ArrayList;
import java.util.List;

import lotto2.domain.LottoNumber;
import lotto2.domain.LottoStatics;
import lotto2.domain.LottoTicket;
import lotto2.domain.LottoTickets;
import lotto2.domain.Rank;

public class ResultView {

	public static void showLottoNumbers(int count, LottoTickets tickets) {
		System.out.println(count + "개를 구매했습니다.");
		StringBuilder result = new StringBuilder();

		for (LottoTicket ticket : tickets) {
			result.append("[ ");
			result.append(showLottoNumber(ticket));
			result.append(" ]\n");
		}
		System.out.println(result);
	}

	public static void showPrize(LottoStatics statics) {
		String result = "\n당첨통계\n";
		result += "---------\n";
		result += "3개 일치 (5000원)- " + statics.getCount(Rank.FIFTH.name()) + "개\n";
		result += "4개 일치 (50000원)- " + statics.getCount(Rank.FOURTH.name()) + "개\n";
		result += "5개 일치 (1500000원)- " + statics.getCount(Rank.THIRD.name()) + "개\n";
		result += "5개 일치, 보너스볼 일치 (3000000원)- " + statics.getCount(Rank.SECOND.name()) + "개\n";
		result += "6개 일치 (2000000000원)- " + statics.getCount(Rank.FIRST.name()) + "개\n";
		System.out.println(result);
		System.out.printf("총 수익률은 %.2f입니다\n", statics.getProfit());
	}

	private static String showLottoNumber(LottoTicket ticket) {
		List<String> elements = new ArrayList<>();
		for (LottoNumber number : ticket.getNumbers()) {
			elements.add(String.valueOf(number.toInt()));
		}
		return String.join(",", elements);
	}

}
