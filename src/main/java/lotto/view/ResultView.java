package lotto.view;

import java.util.Arrays;

import lotto.domain.amount.Amount;
import lotto.domain.lotto.LottoResults;
import lotto.domain.lotto.Lottos;
import lotto.domain.lotto.MatchRank;
import lotto.domain.lotto.WinningLotto;
import lotto.domain.quantity.Quantity;

public class ResultView {
	public void lottosResult(Lottos manualLottos, Lottos randomLottos) {
		System.out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다.\n", manualLottos.getQuantity().getInt(),
			randomLottos.getQuantity().getInt());
		manualLottos.getLottos().forEach(lotto -> System.out.println(new LottoMessage(lotto)));
		randomLottos.getLottos().forEach(lotto -> System.out.println(new LottoMessage(lotto)));
		System.out.print("\n");
	}

	public void winStatisticsResult(Lottos lottos, WinningLotto winningLotto, Amount purchaseAmount) {
		System.out.println("당첨 통계");
		System.out.println("---------");

		LottoResults lottoResults = winningLotto.getLottoResults(lottos);
		Arrays.stream(MatchRank.values()).forEach(matchRank -> {
			if (matchRank == MatchRank.FAILED) {
				return;
			}
			LottoResults filteredLottoResults = lottoResults.filterByMatchRank(matchRank);
			Quantity matchQuantity = filteredLottoResults.quantity();
			System.out.println(new ResultMessage(matchRank, matchQuantity.getInt()));
		});
		System.out.println(new YieldMessage(lottoResults.yield(purchaseAmount)));
	}
}
