package lotto.view;

import java.util.stream.IntStream;

import lotto.domain.amount.Amount;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoResults;
import lotto.domain.lotto.Lottos;
import lotto.domain.match.count.MatchCount;
import lotto.domain.quantity.Quantity;
import lotto.domain.lotto.WinningLotto;

public class ResultView {
	public void lottosResult(Lottos lottos) {
		Quantity quantity = lottos.getQuantity();
		System.out.printf("%d개를 구매했습니다.\n", quantity.getInt());
		for (Lotto lotto : lottos.getLottos()) {
			System.out.println(new LottoMessage(lotto));
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
