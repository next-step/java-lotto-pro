package lotto;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;

public class InputWinningNumbersDto {
    private String winningNumberString;
    private String bonusNumberString;

    private InputWinningNumbersDto(final String winningNumberString, final String bonusNumberString) {
        this.winningNumberString = winningNumberString;
        this.bonusNumberString = bonusNumberString;
    }

    public static InputWinningNumbersDto of(final String winningNumberString, final String bonusNumberString) {
        return new InputWinningNumbersDto(winningNumberString, bonusNumberString);
    }

    public LottoNumbers mapToLottoNumbers() {
        return LottoNumbers.pickNumbers(LottoNumbersMapper.mapToLottoNumbers(winningNumberString));
    }

    public LottoNumber mapToBonusNumber() {
        return LottoNumber.valueOf(bonusNumberString);
    }
}
