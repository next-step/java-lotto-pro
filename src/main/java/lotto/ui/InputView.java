package lotto.ui;

import java.util.Scanner;

public class InputView {

    private static final String MESSAGE_PLEASE_INPUT_MONEY = "구입금액을 입력해 주세요.";
    private static final String MESSAGE_PLEASE_INPUT_LOTTO_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String MESSAGE_PLEASE_INPUT_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";

    public int inputMoneyForPurchase() {
        printPleaseInputMoneyForPurchase();
        return scanNumber();
    }

    private void printPleaseInputMoneyForPurchase() {
        System.out.println(MESSAGE_PLEASE_INPUT_MONEY);
    }

    private int scanNumber() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public String inputReferenceLottoNumbers() {
        printPleaseInputLottoNumbers();
        return scanNumbersString();
    }

    private void printPleaseInputLottoNumbers() {
        System.out.println();
        System.out.println(MESSAGE_PLEASE_INPUT_LOTTO_NUMBER);
    }

    private String scanNumbersString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public int inputBonusLottoNumber() {
        printPleaseInputBonusLottoNumber();
        return scanNumber();
    }

    private void printPleaseInputBonusLottoNumber() {
        System.out.println(MESSAGE_PLEASE_INPUT_BONUS_NUMBER);
    }
}
