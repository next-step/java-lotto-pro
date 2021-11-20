package lotto.view;

import static java.util.stream.Collectors.*;

import java.util.List;

import lotto.domain.wrapper.HitsByMatchedNumberCount;
import lotto.domain.wrapper.LottoTicket;
import lotto.domain.wrapper.LottoWinningMoney;
import lotto.domain.wrapper.Money;

public class Machine {
	public static void showLottoTickets(List<LottoTicket> tickets) {
		tickets.stream()
			.forEach(ticket -> System.out.println(
				'['
					+ ticket.getNumbers().stream()
					.map(x -> x.toString())
					.collect(joining(","))
					+ ']'
				)
			);
	}

	public static void showAnalysis(HitsByMatchedNumberCount hitsByMatchedNumberCount, Money investment,
		Money winnings) {
		System.out.println("당첨 통계\n" + "---------");
		LottoWinningMoney.get().forEach((matchedNumberCount, money) -> {
			System.out.println(matchedNumberCount + "개 일치(" + money + "원)- " +
				hitsByMatchedNumberCount.getHitsByMatchedNumberCount(matchedNumberCount) + "개");
		});

		double profit = winnings.get() - investment.get();
		double profitPercent = profit / investment.get();

		System.out.println("총 수익률은 " + profitPercent + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
	}
}
