package step3.model;

import step3.constant.WinnerRule;

import java.util.ArrayList;
import java.util.List;

import static step3.constant.Constant.*;
import static step3.constant.Message.UNVALID_LOTTO_NUMBER_LENGTH;
import static step3.constant.WinnerRule.rules;
public class LottoCalculator {
    private static List<LottoNumber> lastWeekWinner = new ArrayList<>();
    private static List<Lotto> purchasedLottos;
    private static LottoResult lottoResult = new LottoResult();

    public void setLastWeekLottoNumbers(String beforeNumbers) {
        String[] afterNumbers = validateLastWeekWinner(beforeNumbers);
        lastWeekWinner = new Lotto(afterNumbers).getNumbers();
    }

    public void calculateWinnerStatistics(Lottos lottos) {
        WinnerRule.setWinnerRules();
        purchasedLottos = lottos.getLottos();

        for(Lotto lotto : purchasedLottos) {
            lottoResult.addResult(compareWinnerRules(lotto));
        }
    }

    private int compareWinnerRules(Lotto lotto) {
        int sameCount = ZERO;
        for(LottoNumber lottoNumber : lotto.getNumbers()) {
            sameCount += isContain(lottoNumber);
        }
        return sameCount;
    }

    private int isContain(LottoNumber lottoNumber) {
        return lastWeekWinner.contains(lottoNumber) ? ONE : ZERO;
    }

    private String[] validateLastWeekWinner(String beforeNumbers) {
        LottoGenerator.commonCheckEmpty(beforeNumbers);
        beforeNumbers = beforeNumbers.replaceAll(SPACE, "");
        String[] afterNumbers = beforeNumbers.split(COMMA);
        validateLength(afterNumbers);
        // todo 중복 숫자 확인
        validateNumberType(afterNumbers);

        return afterNumbers;
    }

    private void validateLength(String[] afterNumbers) {
        if(afterNumbers.length != LOTTO_NUMBER_LENGTH) {
            throw new IllegalArgumentException(UNVALID_LOTTO_NUMBER_LENGTH);
        }
    }

    private void validateNumberType(String[] afterNumbers) {
        for(int i=0; i< afterNumbers.length; i++) {
            LottoGenerator.commonStringToNumber(afterNumbers[i]);
        }
    }


    public String createResultMessage(int winnerCount) {
        return new StringBuilder(String.valueOf(winnerCount))
                .append("개 일치 (")
                .append(rules.get(winnerCount))
                .append("원)- ")
                .append(lottoResult.getResultValue(winnerCount))
                .append("개").toString();
    }
}
