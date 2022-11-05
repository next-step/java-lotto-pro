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

import java.util.Optional;
import java.util.Scanner;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);
    private final Spliter spliter = new Spliter();

    int inputPay() {
        printInputPay();
        Optional<String> input = Optional.ofNullable(scanner.nextLine());
        String money = input.orElse("0");
        Validate.validateOnlyNumber(money);
        Validate.validatePay(money);
        return Integer.parseInt(money);
    }

    private void printInputPay() {
        System.out.println(INPUT_PAY_MONEY);
    }

    int inputManualPurchase(int payMoney) {
        printInputManualPurchase();
        String input = scanner.nextLine();
        Validate.validatePurchasableCount(payMoney, Integer.parseInt(input));
        Validate.validateOnlyNumber(input);
        return Integer.parseInt(input);
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
        Validate.validateLottoNumberNull(input);
        Validate.validateLottoNumber(input);
        Validate.validateLottoNumberCount(input);
        Validate.validateLottoNumberRange(input);
        Validate.validateLottoNumberDuplicate(input);
        return LottoNumbers.from(spliter.splitToList(input));
    }

    private void printInputWinningNumberLastWeek() {
        System.out.println(INPUT_WINNING_NUMBER_LAST_WEEK);
    }

    LottoNumber inputBonusNumberLastWeek(LottoNumbers winningNumbers) {
        printInputBonusNumberLastWeek();
        String input = scanner.nextLine();
        Validate.validateOnlyNumber(input);
        Validate.validateLottoNumberRange(input);
        Validate.validateBonusNumberDuplicate(input, winningNumbers);
        return LottoNumber.from(input);
    }

    private void printInputBonusNumberLastWeek() {
        System.out.println(INPUT_BONUS_NUMBER_LAST_WEEK);
    }
}
