package lotto.model;

import java.util.List;
import lotto.constant.LottoMatchNumber;
import lotto.constant.LottoRoleConst;
import lotto.utils.LottoGameValidateUtils;
import lotto.vo.Lotto;
import lotto.vo.Lottos;

public class LottoPlayService {

    private final LottoGeneratorService lottoGeneratorService;

    public LottoPlayService() {
        lottoGeneratorService = new LottoGeneratorService();
    }

    public Lottos convertMoneyToLottos(int money) {
        LottoGameValidateUtils.validateMoney(money);
        int playCount = money / LottoRoleConst.LOTTO_PRICE;
        return new Lottos(playCount);
    }

    public int buyLottoCount(String moneyWord) {
        return 0;
    }

    public Lottos generateLottosByPlayCount(int playCount) {
        Lottos lottos = new Lottos(playCount);
        for (int play = 0; play < lottos.getPlayCount(); play++) {
            Lotto lotto = lottoGeneratorService.generateLotto();
            lottos.addLotto(lotto);
        }
        return lottos;
    }

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
