package lotto.ui.inputView;

import java.util.Scanner;

public class WinningLottoInputView {

    public static String readWinningLotto() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return new Scanner(System.in).nextLine();
    }

    public static String readManualLotto() {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        return new Scanner(System.in).nextLine();
    }
}
