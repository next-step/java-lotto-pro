/*
 * InputView.java
 * v0.1
 * 2022.10.30
 */
package lotto;

import static lotto.Constant.INPUT_PAY_MONEY;
import static lotto.Constant.INPUT_WINNING_NUMBER_LAST_WEEK;

import java.util.List;
import java.util.Scanner;

class InputView {
    private final Scanner scanner = new Scanner(System.in);
    private final Spliter spliter = new Spliter();

    int inputPay() {
        printInputPay();
        return Validate.validatePay(Validate.validateInput(scanner.nextLine()));
    }

    private void printInputPay() {
        System.out.println(INPUT_PAY_MONEY);
    }

    List<Integer> inputWinningNumberLastWeek() {
        printInputWinningNumberLastWeek();
        return spliter.split(scanner.nextLine());
    }

    private void printInputWinningNumberLastWeek() {
        System.out.println("\n" + INPUT_WINNING_NUMBER_LAST_WEEK);
    }
}
