package lotto.controller.acceptor;

import lotto.controller.converter.WinningNumbersConverter;
import lotto.model.lotto.ticket.LottoNumber;
import lotto.model.winning.numbers.WinningNumbers;
import lotto.view.BlankLinePrinter;
import lotto.view.DemandWinningNumbersInputPrinter;

import java.util.List;
import java.util.Scanner;

public class WinningNumbersAcceptor {
    public WinningNumbers accept() {
        BlankLinePrinter.print();
        DemandWinningNumbersInputPrinter.print();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<LottoNumber> lottoNumbers = convertToLottoNumbers(input);
        return new WinningNumbers(lottoNumbers);
    }

    public List<LottoNumber> convertToLottoNumbers(String input) {
        final WinningNumbersConverter winningNumbersConverter = new WinningNumbersConverter(input);
        return winningNumbersConverter.convertToLottoNumbers();
    }
}
