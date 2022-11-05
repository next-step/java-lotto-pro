package lotto.view;

import lotto.constant.LottoMessage;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.Rank;

public class LottoOutPutView {
    public static void writeBuyLottos(Lottos lottos) {
        System.out.printf(LottoMessage.OUTPUT_LOTTO_COUNT, lottos.size());
        for (Lotto lotto : lottos.getLottosAsUnmodifiableList()) {
            System.out.println(lotto.lottoNumbers());
        }
    }

    public static void writeWinResult(LottoResult result) {
        System.out.println(LottoMessage.OUTPUT_LOTTO_RESULT);
        System.out.printf(LottoMessage.OUTPUT_REWARD_RESULT,
                result.getRewardMapCount(Rank.FOURTH),result.getRewardMapCount(Rank.THIRD),result.getRewardMapCount(Rank.SECOND),result.getRewardMapCount(Rank.FIRST));
        System.out.printf(LottoMessage.OUTPUT_PROFIT_RESULT, result.getTotalProfit());
        if (result.getTotalProfit() < 1) {
            System.out.println(LottoMessage.OUTPUT_PROFIT_UNDER);
        }
    }
}
