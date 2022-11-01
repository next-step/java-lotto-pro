package step3.model;

import step3.constant.Rank;
import step3.constant.WinnerRule;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static step3.constant.Constant.Lotto.LOTTO_NUMBER_LENGTH;
import static step3.constant.Constant.Number.*;
import static step3.constant.Constant.Symbols.COMMA;
import static step3.constant.Constant.Symbols.SPACE;
import static step3.constant.Message.Error.*;
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

    public String createResultMessage(Rank rank) {
        String second = rank == Rank.SECOND ? BONUS_CUSTOM_RESULT_MESSAGE : GENERAL_RESULT_MESSAGE;

        return new StringBuilder(String.valueOf(rank.getCountOfMatch()))
                .append(second)
                .append(rank.getWinningMoney())
                .append(WON_RESULT_MESSAGE)
                .append(lottoResult.getWinningCount(rank))
                .append(COUNT_UNIT_RESULT_MESSAGE).toString();
    }

    private void validateLength(String[] afterNumbers) {
        if(afterNumbers.length != LOTTO_NUMBER_LENGTH) {
            throw new IllegalArgumentException(UNVALID_LOTTO_NUMBER_LENGTH);
        }
    }
}
