package step3.domain.input;

import step3.domain.lotto.BonusLottoNumber;
import step3.domain.lotto.LottoNumber;

import static step3.type.ErrorMessageType.INPUT_ONLY_ALLOW_NUMBER;

public class InputBonusLottoNumber implements Input<BonusLottoNumber> {

    @Override
    public BonusLottoNumber create(String input) {
        validateBlank(input);
        try {
            return new BonusLottoNumber(new LottoNumber(Integer.parseInt(input)));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_ONLY_ALLOW_NUMBER.getMessage());
        }
    }
}
