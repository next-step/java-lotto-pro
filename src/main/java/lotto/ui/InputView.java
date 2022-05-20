package lotto.ui;

import java.util.Scanner;

public class InputView {

    private static final String MSG_PLEASE_INPUT_MONEY = "구입금액을 입력해 주세요.";
    private static final String MSG_PLEASE_INPUT_LOTTO_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";

    public Integer inputMoneyForPurchase() {
        printPleaseInputMoneyForPurchase();
        return scanMoneyForPurchase();
    }

    private void printPleaseInputMoneyForPurchase() {
        System.out.println(MSG_PLEASE_INPUT_MONEY);
    }

    private Integer scanMoneyForPurchase() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public String inputReferenceLottoNumbers() {
        printPleaseInputLottoNumbers();
        return scanLottoNumbers();
    }

    private void printPleaseInputLottoNumbers() {
        System.out.println();
        System.out.println(MSG_PLEASE_INPUT_LOTTO_NUMBER);
    }

    private String scanLottoNumbers() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }


}
