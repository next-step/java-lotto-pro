package lotto.view;

import lotto.constant.LottoMessage;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.RewardType;

public class LottoOutPutView {
    public static void writeBuyLottos(Lottos lottos) {
        System.out.printf(LottoMessage.OUTPUT_LOTTO_COUNT, lottos.size());
        for (Lotto lotto : lottos) {
            System.out.println(lotto.lottoNumbers());
        }
    }

    public static void writeWinResult(LottoResult result) {
        System.out.println(LottoMessage.OUTPUT_LOTTO_RESULT);
        System.out.printf(LottoMessage.OUTPUT_REWARD_RESULT,
                result.getRewardMapCount(RewardType.FOURTH),result.getRewardMapCount(RewardType.THIRD),result.getRewardMapCount(RewardType.SECOND),result.getRewardMapCount(RewardType.FIRST));
        System.out.printf(LottoMessage.OUTPUT_PROFIT_RESULT, result.getTotalProfit());
    }
}
