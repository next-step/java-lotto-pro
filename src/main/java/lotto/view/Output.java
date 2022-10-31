package lotto.view;

import lotto.model.Lottos;
import lotto.model.Money;
import lotto.model.Rank;
import lotto.model.Ranks;

public class Output {
	private final static float BREAK_EVEN_POINT = 1.0f;

	private Output() {
	}

	public static void printLottos(final Lottos lottos) {
		System.out.printf("%d개를 구매했습니다\n", lottos.size());
		System.out.println(lottos);
	}

	public static void printResult(final Ranks ranks, final Money payment) {
		float ratio = payment.ratio(ranks.getTotalPrize());
		System.out.println("당첨 통계");
		System.out.println("---------");
		System.out.printf("3개 일치 (5000원)- %d개\n", ranks.count(Rank.FIFTH));
		System.out.printf("4개 일치 (50000원)- %d개\n", ranks.count(Rank.FOURTH));
		System.out.printf("5개 일치 (1500000원)- %d개\n", ranks.count(Rank.THIRD));
		System.out.printf("5개 일치, 보너스 볼 일치(30000000원) - %d개\n", ranks.count(Rank.SECOND));
		System.out.printf("6개 일치 (2000000000원)- %d개\n", ranks.count(Rank.FIRST));
		if (ratio > BREAK_EVEN_POINT) {
			System.out.printf("총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 개이득이라는 의미임)", ratio);
			return;
		}
		System.out.printf("총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)", ratio);
	}
}
