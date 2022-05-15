package lotto.view;

import java.util.List;
import java.util.stream.Collectors;

import lotto.dto.LottoNumber;
import lotto.dto.PrizeReport;

public class OutputView {
	public static void printPurchaseCount(int count) {
		System.out.printf("%d개를 구매했습니다.\n", count);
	}

	public static void printLottoTickets(List<LottoNumber> lottoTickets) {
		for(LottoNumber number: lottoTickets) {
			printLotto(number);
		}
	}

	public static void printPrizeResult(List<PrizeReport> report) {
		System.out.println("당첨 통계");
		System.out.println("---------");

		for(PrizeReport prizeResult: report) {
			System.out.printf("%d개 일치 (%d원)- %d개\n", prizeResult.getMatchCount(), prizeResult.getMoney(), prizeResult.getResult());
		}
	}

	public static void printRate(double rate) {
		System.out.printf("총 수익률은 %5.2f입니다.\n", rate);
	}

	private static void printLotto(LottoNumber lottoNumber) {
		List<Integer> numbers = lottoNumber.getNumbers();
		String printNumbers = numbers.stream()
								.map(number -> number.toString())
								.collect(Collectors.joining(","));

		System.out.printf("[%s]\n", printNumbers);
	}
}
