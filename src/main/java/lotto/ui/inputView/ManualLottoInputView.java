package lotto.ui.inputView;

import java.util.Scanner;

public class ManualLottoInputView {

    public static final String MANUAL_LOTTO_INPUT_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";
    public static final String MANUAL_LOTTO_COUNT_INPUT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";

    public static int readManualLottoCount() {
        System.out.println(MANUAL_LOTTO_COUNT_INPUT_MESSAGE);
        try {
            return Integer.parseInt(new Scanner(System.in).nextLine());
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력해 주세요.");
            return readManualLottoCount();
        }
    }

    public static String readManualLotto() {
        System.out.println(MANUAL_LOTTO_INPUT_MESSAGE);
        return new Scanner(System.in).nextLine();
    }
}
