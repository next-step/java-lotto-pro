package lotto.ui.inputView;

import java.util.Scanner;

public class WinningNumberInputView {

    public static String readWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return new Scanner(System.in).nextLine();
    }
}
