package lotto.view;

import java.util.stream.IntStream;

import lotto.domain.Amount;
import lotto.domain.Lotto;
import lotto.domain.LottoResultMessage;
import lotto.domain.LottoResults;
import lotto.domain.Lottos;
import lotto.domain.MatchCount;
import lotto.domain.Quantity;
import lotto.domain.WinningLotto;
import lotto.domain.YieldMessage;

public class ResultView {
	public void lottosResult(Lottos lottos) {
		Quantity quantity = lottos.getQuantity();
		System.out.printf("%d개를 구매했습니다.\n", quantity.getInt());
		for (Lotto lotto : lottos.getLottos()) {
			System.out.println(lotto.getResultMessage());
		}
		System.out.print("\n");
	}

	public void winStatisticsResult(Lottos lottos, WinningLotto winningLotto, Amount purchaseAmount) {
		System.out.println("당첨 통계");
		System.out.println("---------");

		LottoResults lottoResults = winningLotto.getLottoResults(lottos);
		IntStream.rangeClosed(3, 6).forEach(i -> {
			MatchCount matchCount = MatchCount.from(i);
			LottoResults filteredLottoResults = lottoResults.filterByMatchCount(matchCount);
			Quantity matchQuantity = filteredLottoResults.quantity();
			System.out.println(new LottoResultMessage(matchCount, matchQuantity));
		});
		System.out.println(new YieldMessage(lottoResults.yield(purchaseAmount)));
	}
}
