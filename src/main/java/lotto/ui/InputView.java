package lotto.ui;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import lotto.domain.PurchaseQuantity;

public class InputView {

    private static final String MESSAGE_PLEASE_INPUT_MONEY = "구입금액을 입력해 주세요.";
    private static final String MESSAGE_PLEASE_INPUT_LOTTO_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String MESSAGE_PLEASE_INPUT_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";
    private static final String MESSAGE_PLEASE_INPUT_MANUAL_QUANTITY = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String MESSAGE_PLEASE_INPUT_MANUAL_LOTTO_NUMBERS = "수동으로 구매할 번호를 입력해 주세요.";

    private static final String ERROR_MESSAGE_SCAN_MISMATCH = "숫자를 입력해 주세요.";

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

    public List<String> inputManualLottoNumbers(PurchaseQuantity purchaseQuantity) {
        printMessage(MESSAGE_PLEASE_INPUT_MANUAL_LOTTO_NUMBERS);
        return scanNumbersStringList(purchaseQuantity.getManualQuantity());
    }

    public int inputManualQuantity() {
        printMessage(MESSAGE_PLEASE_INPUT_MANUAL_QUANTITY);
        return scanNumber();
    }


    private int scanNumber() {
        Integer number = null;

        while (number == null) {
            number = scanNumberWithoutException();
        }

        return number;
    }

    private Integer scanNumberWithoutException() {
        Integer number = null;

        try {
            Scanner scanner = new Scanner(System.in);
            number = scanner.nextInt();
        } catch (InputMismatchException exception) {
            printMessage(ERROR_MESSAGE_SCAN_MISMATCH);
        }

        return number;
    }

    private String scanNumbersString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private List<String> scanNumbersStringList(int size) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(scanNumbersString());
        }
        return list;
    }

    private void printMessage(String message) {
        System.out.println(message);
    }
}
