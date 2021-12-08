package lotto.view;

import static java.util.stream.Collectors.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import lotto.domain.wrapper.HitsByRank;
import lotto.domain.wrapper.LottoTicket;
import lotto.domain.wrapper.Rank;

public class Machine {
	private static final String MESSAGE_WINNING_INFO = "당첨 통계\n" + "---------";
	private static final String MESSAGE_MATCHED_STATUS = "%d개 일치(%d)원 - %d개";
	private static final String MESSAGE_MATCHED_STATUS_WITH_BONUS = "%d개 일치, 보너스 볼 일치(%d)원 - %d개";
	private static final String MESSAGE_LOTTO_TICKET_NUMBERS = "[%s]";
	private static final String MESSAGE_TOTAL_PROFIT = "총 수익률은 %f입니다. 기준은 1입니다.";
	private static final String MESSAGE_NO_PROFIT_BEFORE_INVESTMENT = "투자 혹은 당첨 발표 전에는 수익 분석을 할 수 없습니다.";

	public static void showLottoTickets(List<LottoTicket> tickets) {
		tickets.stream()
			.forEach(ticket -> System.out.println(String.format(MESSAGE_LOTTO_TICKET_NUMBERS
				, ticket.getNumbers().stream()
					.map(number -> number.toString())
					.collect(joining(",")))
				)
			);
	}

	public static void showAnalysis(HitsByRank hitsByRank, BigDecimal profitPercent) {
		System.out.println(MESSAGE_WINNING_INFO);
		Arrays.stream(Rank.values()).filter(rank -> rank.getWinningMoney() > 0)
			.forEach(rank ->
				System.out.println(
					String.format(rank.equals(Rank.SECOND) ? MESSAGE_MATCHED_STATUS_WITH_BONUS : MESSAGE_MATCHED_STATUS
						, rank.getCountOfMatch()
						, rank.getWinningMoney()
						, hitsByRank.getHitsByRank(rank))));

		System.out.println(String.format(MESSAGE_TOTAL_PROFIT, profitPercent));
	}

	public static void showBeforeInvestment() {
		System.out.println(MESSAGE_NO_PROFIT_BEFORE_INVESTMENT);
	}
}
