package lotto.model;

import java.util.List;
import lotto.constant.LottoMatchNumber;
import lotto.constant.LottoRoleConst;
import lotto.utils.LottoGameValidateUtils;

public class LottoPlayService {


    public void playLottoGame(Lottos lottos, List<Integer> winningNumberList) {
        LottoGameValidateUtils.validateWinningNumberList(winningNumberList);
        for (Lotto lotto : lottos.getLottoList()) {
            int matchNumberCount = lotto.matchNumberCount(winningNumberList);
            lottos.updateResultCountMap(matchNumberCount);
        }
        calculateProfitRate(lottos);
    }

    private void calculateProfitRate(Lottos lottos) {
        int money = lottos.getPlayCount() * LottoRoleConst.LOTTO_PRICE;
        int totalWinningAmount = 0;
        for (LottoMatchNumber lottoMatchNumber : LottoMatchNumber.allMatchNumber()) {
            totalWinningAmount +=
                    lottos.getResultCount(lottoMatchNumber.getMatchNumberCount()) * lottoMatchNumber.getWinningAmount();
        }
        double resultProfitRate = (double) totalWinningAmount / money;
        lottos.setResultProfitRate(resultProfitRate);
    }
}
