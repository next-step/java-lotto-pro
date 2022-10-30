package lotto.controller.acceptor;

import lotto.model.winning.numbers.WinningNumbers;
import lotto.view.DemandWinningNumbersInputPrinter;

import java.util.Scanner;

/**
 * UI 에서 당첨 번호 6 개를 입력 받는 객체이다.
 */
public class WinningNumbersAcceptor {
    public WinningNumbers accept() {
        DemandWinningNumbersInputPrinter.print();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return new WinningNumbers(input);
    }
}
