/*
 * InputView.java
 * v0.1
 * 2022.10.30
 */
package lotto;

import static lotto.Constant.INPUT_BONUS_NUMBER_LAST_WEEK;
import static lotto.Constant.INPUT_PAY_MONEY;
import static lotto.Constant.INPUT_WINNING_NUMBER_LAST_WEEK;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);
    private final Spliter spliter = new Spliter();

    int inputPay() {
        printInputPay();
        String input = scanner.nextLine();
        Validate.validateCostNull(input);
        Validate.validateOnlyNumber(input);
        Validate.validatePay(input);
        return Integer.parseInt(input);
    }

    private void printInputPay() {
        System.out.println(INPUT_PAY_MONEY);
    }

    LottoNumbers inputWinningNumberLastWeek() {
        printInputWinningNumberLastWeek();
        String input = scanner.nextLine();
        Validate.validateWinningNumberNull(input);
        Validate.validateWinningNumber(input);
        Validate.validateWinningNumberCount(input);
        Validate.validateWinningNumberRange(input);
        Validate.validateWinningNumberDuplicate(input);
        return spliter.split(input);
    }

    private void printInputWinningNumberLastWeek() {
        System.out.println("\n" + INPUT_WINNING_NUMBER_LAST_WEEK);
    }

    LottoNumber inputBonusNumberLastWeek(LottoNumbers winningNumbers) {
        printInputBonusNumberLastWeek();
        String input = scanner.nextLine();
        Validate.validateOnlyNumber(input);
        Validate.validateWinningNumberRange(input);
        Validate.validateBonusNumberDuplicate(input, winningNumbers);
        return LottoNumber.from(input);
    }

    private void printInputBonusNumberLastWeek() {
        System.out.println(INPUT_BONUS_NUMBER_LAST_WEEK);
    }
}
