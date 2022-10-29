package step3.domain.input;

import step3.domain.lotto.WinningLottoNumbers;

public class InputWinningLottoNumbers implements Input<WinningLottoNumbers> {

    @Override
    public WinningLottoNumbers create(String input) {
        validateBlank(input);
        return new WinningLottoNumbers(input);
    }
}
