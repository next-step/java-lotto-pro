package lotto.controller.acceptor;

import lotto.model.winning.numbers.WinningNumbers;
import lotto.view.DemandWinningNumbersInputPrinter;

import java.util.Scanner;

public class WinningNumbersAcceptor {
    public WinningNumbers accept() {
        DemandWinningNumbersInputPrinter.print();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return new WinningNumbers(input);
    }
}
