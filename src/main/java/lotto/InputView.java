/*
 * InputView.java
 * v0.1
 * 2022.10.30
 */
package lotto;

import static lotto.Constant.INPUT_BONUS_NUMBER_LAST_WEEK;
import static lotto.Constant.INPUT_MANUAL_LOTTO_NUMBER;
import static lotto.Constant.INPUT_MANUAL_PURCHASE;
import static lotto.Constant.INPUT_PAY_MONEY;
import static lotto.Constant.INPUT_WINNING_NUMBER_LAST_WEEK;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);
    private final Spliter spliter = new Spliter();

    String inputPay() {
        printInputPay();
        String input = scanner.nextLine();
        Validate.isEmpty(input);
        return input;
    }

    private void printInputPay() {
        System.out.println(INPUT_PAY_MONEY);
    }

    String inputManualPurchase() {
        printInputManualPurchase();
        String input = scanner.nextLine();
        Validate.isEmpty(input);
        return input;
    }

    private void printInputManualPurchase() {
        System.out.println(INPUT_MANUAL_PURCHASE);
    }

    public void printInputManualLottoNumber() {
        System.out.println(INPUT_MANUAL_LOTTO_NUMBER);
    }

    LottoNumbers inputWinningNumberLastWeek() {
        printInputWinningNumberLastWeek();
        String input = scanner.nextLine();
        Validate.isEmpty(input);
        Validate.isDuplicate(input);
        return LottoNumbers.from(spliter.splitToList(input));
    }

    private void printInputWinningNumberLastWeek() {
        System.out.println(INPUT_WINNING_NUMBER_LAST_WEEK);
    }

    LottoNumber inputBonusNumberLastWeek(LottoNumbers winningNumbers) {
        printInputBonusNumberLastWeek();
        String input = scanner.nextLine();
        Validate.isEmpty(input);
        Validate.isDuplicate(input, winningNumbers);
        return LottoNumber.from(input);
    }

    private void printInputBonusNumberLastWeek() {
        System.out.println(INPUT_BONUS_NUMBER_LAST_WEEK);
    }
}
