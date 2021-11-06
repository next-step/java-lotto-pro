package lotto;

import java.util.List;
import java.util.Scanner;

public class OutputView {
	private static Scanner scanner = new Scanner(System.in);

	public static void printMessage(String message) {
		System.out.println(message);
	}

	public static void printPurchaseQuantity(int purchaseQuantity) {
		System.out.printf(CommonMessage.PRINT_PURCHASE_QUANTITY, purchaseQuantity);
	}

	public static void newLine() {
		System.out.println();
	}

	public static void printLottoStatisticsHeader() {
		System.out.println(CommonMessage.PRINT_LOTTO_STATISTICS_HEADER);
	}

	public static void printLottoStatisticsBody(List<WinningInformation> winningRecord, double profitRate) {
		printWinningInformation(winningRecord);
		printProfitRate(profitRate);
	}

	private static void printWinningInformation(List<WinningInformation> winningRecord) {
		for (WinningInformation information : winningRecord) {
			System.out.printf(CommonMessage.PRINT_WINNING_INFORMATION,
				information.getMatchedNumber(),
				information.getWinningAmount(),
				information.getWinnerCount());
			newLine();
		}

	}

	private static void printProfitRate(double profitRate) {
		System.out.printf(CommonMessage.PRINT_PROFIT_RATE, profitRate);
	}
}
