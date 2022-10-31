package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.RewardType;

public class LottoOutPutView {
    public static void writeBuyLottos(Lottos lottos) {
        System.out.printf("%d개를 구매했습니다.%n", lottos.size());
        for (Lotto lotto : lottos) {
            System.out.println(lotto.lottoNumbers());
        }
    }

    public static void writeWinResult(LottoResult result) {
        System.out.println("당첨 통계\n ---------");
        System.out.printf("3개 일치 (5000원)- %d개\n4개 일치 (50000원)- %d개\n5개 일치 (1500000원)- %d개\n6개 일치 (2000000000원)- %d개%n",
                result.getRewardMapCount(RewardType.FOURTH),result.getRewardMapCount(RewardType.THIRD),result.getRewardMapCount(RewardType.SECOND),result.getRewardMapCount(RewardType.FIRST));
        System.out.printf("총 수익률은 %.2f입니다.%n", result.getTotalProfit());
    }
}
