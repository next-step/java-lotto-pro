package lotto.view;

import java.util.List;
import java.util.stream.Collectors;

import lotto.dto.LottoNumber;
import lotto.dto.PrizeReport;

public class OutputView {
	private static final String WINNING_STATS = "당첨 통계";
	private static final String UNDER_LINE = "---------";
	private static final String PURCHASE_MESSAGE = "%d개를 구매했습니다.\n";
	private static final String RATIO_MESSAGE = "총 수익률은 %5.2f입니다.\n";
	private static final String WINNING_RESULT_MESSAGE = "%d개 일치 (%d원)- %d개\n";

	public static void printPurchaseCount(int count) {
		System.out.printf(PURCHASE_MESSAGE, count);
	}

	public static void printLottoTickets(List<LottoNumber> lottoTickets) {
		for(LottoNumber number: lottoTickets) {
			printLotto(number);
		}
	}

	public static void printPrizeResult(List<PrizeReport> report) {
		System.out.println(WINNING_STATS);
		System.out.println(UNDER_LINE);

		for(PrizeReport prizeResult: report) {
			System.out.printf(WINNING_RESULT_MESSAGE, prizeResult.getMatchCount(), prizeResult.getMoney(), prizeResult.getResult());
		}
	}

	public static void printRate(double rate) {
		System.out.printf(RATIO_MESSAGE, rate);
	}

	private static void printLotto(LottoNumber lottoNumber) {
		List<Integer> numbers = lottoNumber.getNumbers();
		String printNumbers = numbers.stream()
								.map(Object::toString)
								.collect(Collectors.joining(","));

		System.out.printf("[%s]\n", printNumbers);
	}
}
