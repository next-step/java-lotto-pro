package step3.view.input;

import step3.domain.lotto.WinningLottoNumbers;

public class InputWinningLottoNumbers implements Input<WinningLottoNumbers> {

    @Override
    public WinningLottoNumbers create() {
        String input = scanner.nextLine();
        validateBlank(input);
        return new WinningLottoNumbers(input);
    }
}
