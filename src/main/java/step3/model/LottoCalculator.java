package step3.model;

import step3.constant.WinnerRule;

import java.util.List;

import static step3.constant.Constant.ONE;
import static step3.constant.Constant.ZERO;
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

    public void calculateWinnerStatistics(Lottos lottos) {
        WinnerRule.setWinnerRules();
        purchasedLottos = lottos.getLottos();
        for(Lotto lotto : purchasedLottos) {
            lottoResult.addResult(compareWinnerRules(lotto));
        }
    }

    public double calculateProfitRate() {
        return lottoResult.calculateProfitRate(purchasedLottos.size());
    }

    private int compareWinnerRules(Lotto lotto) {
        int sameCount = ZERO;
        for(LottoNumber lottoNumber : lotto.getNumbers()) {
            sameCount += isContainNumber(lottoNumber);
        }
        return sameCount;
    }

    private int isContainNumber(LottoNumber lottoNumber) {
        return lastWeekWinner.isContain(lottoNumber) ? ONE : ZERO;
    }

    public String createResultMessage(int winnerCount) {
        return new StringBuilder(String.valueOf(winnerCount))
                .append("개 일치 (")
                .append(rules.get(winnerCount))
                .append("원)- ")
                .append(lottoResult.getResultValue(winnerCount))
                .append("개").toString();
    }

    public void setLastWeekWinner(Lotto lotto) {
        lastWeekWinner = lotto;
    }
}
