package lotto.ui.inputView;

import java.util.Scanner;

public class ManualLottoInputView {

    public static int readManualLottoCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        try {
            return Integer.parseInt(new Scanner(System.in).nextLine());
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력해 주세요.");
            return readManualLottoCount();
        }
    }
}
