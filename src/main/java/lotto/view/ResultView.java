package lotto.view;

import java.util.Arrays;
import java.util.Comparator;

import lotto.constants.Rank;
import lotto.model.Lottos;
import lotto.model.Prize;
import lotto.model.PurchaseMoney;
import lotto.util.LottoGenerator;

public class ResultView {
	public static Lottos purchaseLottos(PurchaseMoney money) {
		Lottos lottos = LottoGenerator.purchaseLottos(money.purchase());
		System.out.printf("%d개를 구매했습니다.%n", lottos.size());
		System.out.println(lottos);
		System.out.println();
		return lottos;
	}

	public static void printResult(Prize prize, PurchaseMoney money) {
		System.out.println();
		System.out.println("당첨 통계");
		System.out.println("---------");
		Arrays.stream(Rank.values())
			.filter(rank -> rank != Rank.MISS)
			.sorted(Comparator.comparingInt(Rank::getCountOfMatch))
			.forEach(rank -> {
				if (rank == Rank.SECOND) {
					System.out.printf("%d개 일치, 보너스 볼 일치(%d원)- %d개%n", rank.getCountOfMatch(), rank.getWinningMoney(),
						prize.getCount(rank));
					return;
				}
				System.out.printf("%d개 일치 (%d원)- %d개%n", rank.getCountOfMatch(), rank.getWinningMoney(),
					prize.getCount(rank));
			});
		System.out.printf("총 수익률은 %.2f입니다.%n", Math.floor(prize.rateReturn(money) * 100) / 100);
	}
}
