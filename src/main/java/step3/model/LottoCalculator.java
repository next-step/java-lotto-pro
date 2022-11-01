package step3.model;

import step3.constant.Rank;
import step3.constant.WinnerRule;

import java.util.List;

import static step3.constant.Constant.ONE;
import static step3.constant.Constant.ZERO;
import static step3.constant.Message.*;
import static step3.constant.WinnerRule.rules;
public class LottoCalculator {

    private static Lotto lastWeekWinner;
    private static List<Lotto> purchasedLottos;
    private static LottoResult lottoResult;


    public LottoCalculator() {
        this.lastWeekWinner = new Lotto();
        this.lottoResult = new LottoResult();
    }
    public LottoCalculator(Lotto lastWeekWinner) {
        this.lastWeekWinner = lastWeekWinner;
    }

    public Lotto getLastWeekWinner() {
        return lastWeekWinner;
    }

//    public void calculateWinnerStatistics(Lottos lottos) {
//        WinnerRule.setWinnerRules();
//        purchasedLottos = lottos.getLottos();
//        for(Lotto lotto : purchasedLottos) {
//            lottoResult.addResult(compareWinnerRules(lotto));
//        }
//    }

    public void calculateWinnerStatistics(Lottos lottos) {
        purchasedLottos = lottos.getLottoList();
        for(Lotto lotto : purchasedLottos) {
            lottoResult.addResult(compareWinnerRules(lotto), isEqualToBonusNumber(lotto));
        }
    }

    private boolean isEqualToBonusNumber(Lotto lotto) {
        return lotto.isMatchNumber(lastWeekWinner.getBonusNumber());
    }

    public double calculateProfitRate() {
        return lottoResult.calculateProfitRate(purchasedLottos.size());
    }

    private int compareWinnerRules(Lotto lotto) {
        int sameCount = ZERO;
        for(LottoNumber lottoNumber : lotto.getNumbers()) {
            sameCount += countMatchNumber(lottoNumber);
        }
        return sameCount;
    }

    private int countMatchNumber(LottoNumber lottoNumber) {
        return lastWeekWinner.isMatchNumber(lottoNumber) ? ONE : ZERO;
    }

    public String createResultMessage(Rank rank) {
        String second = rank == Rank.SECOND ? BONUS_CUSTOM_RESULT_MESSAGE : GENERAL_RESULT_MESSAGE;

        return new StringBuilder(String.valueOf(rank.getCountOfMatch()))
                .append(second)
                .append(rank.getWinningMoney())
                .append(WON_RESULT_MESSAGE)
                .append(lottoResult.getResultValue(rank))
                .append(COUNT_UNIT_RESULT_MESSAGE).toString();
    }

    public void setLastWeekWinner(Lotto lotto) {
        lastWeekWinner = lotto;
    }
}
