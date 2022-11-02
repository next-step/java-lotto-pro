package lotto.model.winning.numbers;

import lotto.controller.converter.WinningNumbersConverter;
import lotto.model.lotto.ticket.LottoNumber;

import java.util.List;

public class WinningNumbers {
    private final List<LottoNumber> lottoNumbers;

    public WinningNumbers(String input) {
        final WinningNumbersConverter winningNumbersConverter = new WinningNumbersConverter(input);
        lottoNumbers = winningNumbersConverter.convertToLottoNumbers();
    }

    public List<LottoNumber> lottoNumbers() {
        return lottoNumbers;
    }
}
