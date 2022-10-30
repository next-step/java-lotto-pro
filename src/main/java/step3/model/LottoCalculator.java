package step3.model;

import java.util.List;

import static step3.constant.Constant.COMMA;
import static step3.constant.Constant.SPACE;
import static step3.constant.Constant.LOTTO_NUMBER_LENGTH;
import static step3.constant.Message.UNVALID_LOTTO_NUMBER_LENGTH;

public class LottoCalculator {
    private static Lotto lastWeekWinner = new Lotto();
    private static List<Lotto> purchasedLottos;

    public void setLastWeekLottoNumbers(String beforeNumbers) {
        String[] afterNumbers = validateLastWeekWinner(beforeNumbers);
        lastWeekWinner.setLastWeekWinner(afterNumbers);
    }

    public void calculateWinnerStatistics(Lottos lottos) {
        purchasedLottos = lottos.getLottos();

        for(Lotto lotto : purchasedLottos) {
            

        }
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



}
