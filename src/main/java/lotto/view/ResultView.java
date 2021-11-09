package lotto.view;

import java.util.Arrays;
import java.util.Comparator;

import lotto.constants.Rank;
import lotto.model.Prize;

public class ResultView {
	public static void printResult(Prize prize, int purchaseMoney) {
		System.out.println();
		System.out.println("당첨 통계");
		System.out.println("---------");
		Arrays.stream(Rank.values())
			.filter(rank -> rank != Rank.MISS)
			.sorted(Comparator.comparingInt(Rank::getMatchCount))
			.forEach(rank -> {
				System.out.printf("%d개 일치 (%d원)- %d개%n", rank.getMatchCount(), rank.getPrize(), prize.getCount(rank));
			});
		System.out.printf("총 수익률은 %.2f입니다.%n", Math.floor(prize.rateReturn(purchaseMoney) * 100) / 100);
	}
}
