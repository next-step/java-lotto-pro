package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.MatchCount;
import lotto.domain.WinningLotto;

public class ResultView {
	public void lottosResult(Lottos lottos) {
		System.out.printf("%d개를 구매했습니다.\n", lottos.getQuantity());
		for (Lotto lotto : lottos.getLottos()) {
			System.out.println(lotto.getResultMessage());
		}
		System.out.print("\n");
	}

	public void winStatisticsResult(Lottos lottos, WinningLotto winningLotto) {
		System.out.println("당첨 통계");
		System.out.println("---------");
		for (int i = 3 ; i<= 6; i++) {
			System.out.println(winningLotto.getResultMessage(lottos, MatchCount.from(i)));
		}
		System.out.println(winningLotto.getYieldMessage(lottos));}
}
