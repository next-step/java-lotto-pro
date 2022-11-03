package step3.model;

import java.util.List;

import static step3.constant.Message.Error.SMAE_BONUS_NUMBER;
import static step3.utils.CommonUtils.commonCheckEmpty;
import static step3.utils.CommonUtils.commonStringToNumber;

public class WinnerLotto extends Lotto{
    private LottoNumber bonusNumber;


    public WinnerLotto(List<LottoNumber> list, String StringNumber) {
        super(list);
        this.bonusNumber = new LottoNumber(validateBonusNumber(StringNumber));
    }

    public WinnerLotto() {

    }

    public WinnerLotto(List<LottoNumber> list) {
        super(list);
    }


    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }
    private int validateBonusNumber(String stringNumber) {
        commonCheckEmpty(stringNumber);
        int number = commonStringToNumber(stringNumber);
        checkWinningNumbersContainBonusNumber(number);
        return number;
    }

    private void checkWinningNumbersContainBonusNumber(int number) {
        if(isMatchNumber(new LottoNumber(number))) {
            throw new IllegalArgumentException(SMAE_BONUS_NUMBER);
        }
    }
}
