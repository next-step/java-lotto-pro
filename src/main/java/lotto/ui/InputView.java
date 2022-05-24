package lotto.ui;

import java.util.Scanner;

public class InputView {

    private static final String MESSAGE_PLEASE_INPUT_MONEY = "구입금액을 입력해 주세요.";
    private static final String MESSAGE_PLEASE_INPUT_LOTTO_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String MESSAGE_PLEASE_INPUT_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";
    private static final String MESSAGE_PLEASE_INPUT_MANUAL_QUANTITY = "수동으로 구매할 로또 수를 입력해 주세요.";

    public int inputMoneyForPurchase() {
        printMessage(MESSAGE_PLEASE_INPUT_MONEY);
        return scanNumber();
    }

    public int inputBonusLottoNumber() {
        printMessage(MESSAGE_PLEASE_INPUT_BONUS_NUMBER);
        return scanNumber();
    }

    public String inputReferenceLottoNumbers() {
        printMessage(MESSAGE_PLEASE_INPUT_LOTTO_NUMBER);
        return scanNumbersString();
    }

    public int inputManualQuantity() {
        printMessage(MESSAGE_PLEASE_INPUT_MANUAL_QUANTITY);
        return scanNumber();
    }


    private int scanNumber() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private String scanNumbersString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private void printMessage(String message) {
        System.out.println(message);
    }
}
