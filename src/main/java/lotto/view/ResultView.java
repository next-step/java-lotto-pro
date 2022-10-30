package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.MatchResult;
import lotto.domain.WinningStatistics;

public class ResultView {
	public void lottosResult(Lottos lottos) {
		System.out.printf("%d개를 구매했습니다.\n", lottos.getQuantity());
		for (Lotto lotto : lottos.getLottos()) {
			System.out.println(lotto.toString());
		}
		System.out.print("\n");
	}

	public void winStatisticsResult(WinningStatistics winningStatistics, Lottos lottos) {
		System.out.println("당첨 통계");
		System.out.println("---------");
		for (MatchResult matchResult : winningStatistics.getMatchResults(lottos)) {
			System.out.println(matchResult.toString());
		}
		System.out.printf("총 수익률은 %.2f입니다.%n", winningStatistics.getYield());
	}
}
