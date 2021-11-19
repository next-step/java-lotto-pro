package lotto.view;

import java.util.Arrays;
import java.util.Comparator;

import lotto.constants.Rank;
import lotto.model.Lottos;
import lotto.model.Prize;
import lotto.model.PurchaseMoney;

public class ResultView {
	public static void printPurchasedLottos(int numberOfManualLotto, Lottos lottos) {
		System.out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다.%n", numberOfManualLotto, lottos.size() - numberOfManualLotto);
		System.out.println(lottos);
		System.out.println();
	}

	public static void printResult(Prize prize, PurchaseMoney money) {
		System.out.println();
		System.out.println("당첨 통계");
		System.out.println("---------");
		Arrays.stream(Rank.values())
			.filter(rank -> rank != Rank.MISS)
			.sorted(Comparator.comparingInt(Rank::getCountOfMatch).thenComparingInt(Rank::getWinningMoney))
			.forEach(rank -> printPrizeStatistics(prize, rank));
		System.out.printf("총 수익률은 %s입니다.%n", prize.rateReturn(money));
	}

	private static void printPrizeStatistics(Prize prize, Rank rank) {
		if (rank == Rank.SECOND) {
			System.out.printf("%d개 일치, 보너스 볼 일치(%d원)- %d개%n", rank.getCountOfMatch(), rank.getWinningMoney(),
				prize.getCount(rank));
			return;
		}
		System.out.printf("%d개 일치 (%d원)- %d개%n", rank.getCountOfMatch(), rank.getWinningMoney(),
			prize.getCount(rank));
	}
}
