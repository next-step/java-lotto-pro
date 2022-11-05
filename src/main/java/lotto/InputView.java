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
        Optional<String> inputOptional = Optional.ofNullable(scanner.nextLine());
        String input = inputOptional.orElse("0");
        Validate.validateEmpty(input);
        Validate.validateOnlyNumber(input);
        Validate.validatePay(input);
        return Integer.parseInt(input);
    }

    private void printInputPay() {
        System.out.println(INPUT_PAY_MONEY);
    }

    int inputManualPurchase(int payMoney) {
        printInputManualPurchase();
        Optional<String> inputOptional = Optional.ofNullable(scanner.nextLine());
        String input = inputOptional.orElse("0");
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
        Optional<String> inputOptional = Optional.ofNullable(scanner.nextLine());
        String input = inputOptional.orElse("");
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
        Optional<String> inputOptional = Optional.ofNullable(scanner.nextLine());
        String input = inputOptional.orElse("");
        Validate.validateOnlyNumber(input);
        Validate.validateLottoNumberRange(input);
        Validate.validateBonusNumberDuplicate(input, winningNumbers);
        return LottoNumber.from(input);
    }

    private void printInputBonusNumberLastWeek() {
        System.out.println(INPUT_BONUS_NUMBER_LAST_WEEK);
    }
}
