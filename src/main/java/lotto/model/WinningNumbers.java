package lotto.model;

import java.util.List;

import static lotto.utils.InputUtils.convertToIntegerList;
import static lotto.utils.InputUtils.splitWithDelimiter;
import static lotto.view.InputView.readWinningNumbers;

public class WinningNumbers {
    private final LottoNumbers winningNumbers;

    private WinningNumbers(LottoNumbers winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public static WinningNumbers createWinningNumbers() {
        List<Integer> numbers = convertToIntegerList(splitWithDelimiter(readWinningNumbers()));
        LottoNumbers winningNumbers = LottoNumbers.createLottoNumbers(numbers);
        return new WinningNumbers(winningNumbers);
    }
}
