package lotto.console;

import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoResult;
import lotto.domain.LottoShop;
import lotto.domain.Rank;

public class OutputView {
	private static final String PRINT_PURCHASE_QUANTITY = "%d개를 구매했습니다.\n";
	private static final String PRINT_LOTTO_STATISTICS_HEADER = "당첨 통계 \n--------";
	private static final String PRINT_WINNING_INFORMATION = "%d개 일치 (%d원)- %d개\n";
	private static final String PRINT_WINNING_INFORMATION_SECOND = "%d개 일치, 보너스 볼 일치(%d원)- %d개\n";
	private static final String PRINT_PROFIT_RATE = "총 수익률은 %.2f입니다.";
	private static final String PRINT_PURCHASED_LOTTO_NUMBERS = "[%s]\n";

	public static void printMessage(String message) {
		if (isBlank(message)) {
			return;
		}
		System.out.println(message);
	}

	private static boolean isBlank(String message) {
		return message.equals("");
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

	public static void printPurchasedLottoNumbers(List<Lotto> lottos) {
		for (Lotto lotto : lottos) {
			System.out.printf(PRINT_PURCHASED_LOTTO_NUMBERS, extractStringValue(lotto));
		}
	}

	private static String extractStringValue(Lotto lotto) {
		String lottoNumberStringValue = "";
		for (LottoNumber lottoNumber : lotto.getLottoNumbers()) {
			lottoNumberStringValue += lottoNumber.getValue() + Lotto.DELIMITER;
		}
		return lottoNumberStringValue.substring(0, lottoNumberStringValue.length() - 2);
	}

	public static void printLottoStatisticsBody(LottoResult lottoResult) {
		double profitSum = 0;
		for (Rank rank : Rank.values()) {
			int winnerOfCount = lottoResult.countWinner(rank);
			printFifthToThird(rank, winnerOfCount);
			printSecond(rank, winnerOfCount);
			printFist(rank, winnerOfCount);
			profitSum += rank.getWinningAmount() * winnerOfCount;
		}
		double profitRate = profitSum / (LottoShop.LOTTO_PRICE.multiply(lottoResult.countLotto()));
		System.out.printf(PRINT_PROFIT_RATE, profitRate);
	}

	private static void printFifthToThird(Rank rank, int winners) {
		if (rank == Rank.FIFTH || rank == Rank.FOURTH || rank == Rank.THIRD) {
			System.out.printf(PRINT_WINNING_INFORMATION,
				rank.getCountOfMatch(),
				rank.getWinningAmount(),
				winners
			);
		}
	}

	private static void printSecond(Rank rank, int winners) {
		if (rank == Rank.SECOND) {
			System.out.printf(PRINT_WINNING_INFORMATION_SECOND,
				rank.getCountOfMatch(),
				rank.getWinningAmount(),
				winners
			);
		}
	}

	private static void printFist(Rank rank, int winners) {
		if (rank == Rank.FIRST) {
			System.out.printf(PRINT_WINNING_INFORMATION,
				rank.getCountOfMatch(),
				rank.getWinningAmount(),
				winners
			);
		}
	}
}
