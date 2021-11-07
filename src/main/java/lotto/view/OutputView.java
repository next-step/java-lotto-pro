package lotto.view;

import java.util.List;
import java.util.Scanner;

import lotto.domain.WinningInformation;

public class OutputView {
	private static final String PRINT_PURCHASE_QUANTITY = "%d개를 구매했습니다.\n";
	private static final String PRINT_LOTTO_STATISTICS_HEADER = "당첨 통계 \n--------";
	private static final String PRINT_WINNING_INFORMATION = "%d개 일치 (%d원)- %d개\n";
	private static final String PRINT_PROFIT_RATE = "총 수익률은 %.2f입니다.";
	private static final String PRINT_PURCHASED_LOTTO_NUMBERS = "[%s]\n";


	private static final Scanner scanner = new Scanner(System.in);

	public static void printMessage(String message) {
		System.out.println(message);
	}

	public static void printPurchaseQuantity(int purchaseQuantity) {
		System.out.printf(PRINT_PURCHASE_QUANTITY, purchaseQuantity);
	}

	public static void newLine() {
		System.out.println();
	}

	public static void printLottoStatisticsHeader() {
		System.out.println(PRINT_LOTTO_STATISTICS_HEADER);
	}

	public static void printLottoStatisticsBody(List<WinningInformation> winningRecord, double profitRate) {
		printWinningInformation(winningRecord);
		printProfitRate(profitRate);
	}

	private static void printWinningInformation(List<WinningInformation> winningRecord) {
		for (WinningInformation information : winningRecord) {
			System.out.printf(PRINT_WINNING_INFORMATION,
				information.getMatchedNumber(),
				information.getWinningAmount(),
				information.getWinnerCount());
		}

	}

	private static void printProfitRate(double profitRate) {
		System.out.printf(PRINT_PROFIT_RATE, profitRate);
	}

	public static void printPurchasedLottoNumbers(String lottoNumbersStringValues) {
		System.out.printf(PRINT_PURCHASED_LOTTO_NUMBERS, lottoNumbersStringValues);
	}
}
