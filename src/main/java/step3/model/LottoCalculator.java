package step3.model;

import step3.constant.Rank;

import java.util.ArrayList;
import java.util.List;

import static step3.constant.Constant.Common.ONE;
import static step3.constant.Constant.Common.ZERO;
import static step3.constant.Message.Output.*;

public class LottoCalculator {

    private Lotto lastWeekWinner;
    private List<Lotto> purchasedLottos;
    private LottoResult lottoResult = new LottoResult();

    public LottoCalculator() {
        this.lastWeekWinner = new Lotto();
        this.purchasedLottos = new ArrayList<>();
    }
    public LottoCalculator(Lotto lastWeekWinner) {
        this.lastWeekWinner = lastWeekWinner;
    }

    public Lotto getLastWeekWinner() {
        return lastWeekWinner;
    }
    public LottoResult getLottoResult() { return lottoResult; }

    public void setLastWeekWinner(Lotto lotto) {
        lastWeekWinner = lotto;
    }

    public void calculateWinnerStatistics(Lottos lottos) {
        purchasedLottos = lottos.getLottoList();
        for(Lotto lotto : purchasedLottos) {
            lottoResult.addResult(compareWinnerRules(lotto), isEqualToBonusNumber(lotto));
        }
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

    private boolean isEqualToBonusNumber(Lotto lotto) {
        return lotto.isMatchNumber(lastWeekWinner.getBonusNumber());
    }

    public double calculateProfitRate() {
        return lottoResult.calculateProfitRate(purchasedLottos.size());
    }
}
