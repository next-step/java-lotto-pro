package lotto.view;

import java.util.List;

import lotto.controller.LottoApplicationController;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
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
			lottoNumberStringValue += lottoNumber.getValue() + ", ";
		}
		return lottoNumberStringValue.substring(0, lottoNumberStringValue.length() - 2);
	}

	public static void printLottoStatisticsBody(List<Lotto> lottos) {
		double profitSum = 0;
		for (Rank rank : Rank.values()) {
			printFifthToThird(rank, lottos);
			printSencod(rank, lottos);
			printFist(rank, lottos);
			profitSum += rank.getWinningAmount() * countWinners(rank, lottos);
		}
		double profitRate = profitSum / (LottoApplicationController.LOTTO_PRICE * lottos.size());
		System.out.printf(PRINT_PROFIT_RATE, profitRate);
	}

	private static void printFifthToThird(Rank rank, List<Lotto> lottos) {
		if (rank == Rank.FIFTH || rank == Rank.FOURTH || rank == Rank.THIRD) {
			System.out.printf(PRINT_WINNING_INFORMATION,
				rank.getCountOfMatch(),
				rank.getWinningAmount(),
				countWinners(rank, lottos)
			);
		}
	}

	private static void printSencod(Rank rank, List<Lotto> lottos) {
		if (rank == Rank.SECOND) {
			System.out.printf(PRINT_WINNING_INFORMATION_SECOND,
				rank.getCountOfMatch(),
				rank.getWinningAmount(),
				countWinners(rank, lottos)
			);
		}
	}

	private static void printFist(Rank rank, List<Lotto> lottos) {
		if (rank == Rank.FIRST) {
			System.out.printf(PRINT_WINNING_INFORMATION,
				rank.getCountOfMatch(),
				rank.getWinningAmount(),
				countWinners(rank, lottos)
			);
		}
	}

	private static int countWinners(Rank rank, List<Lotto> lottos) {
		int count = 0;
		for (Lotto lotto : lottos) {
			count += ifSameRankCount(rank, lotto);
		}
		return count;
	}

	private static int ifSameRankCount(Rank rank, Lotto lotto) {
		return rank == lotto.getWinningRank() ? 1 : 0;
	}
}
