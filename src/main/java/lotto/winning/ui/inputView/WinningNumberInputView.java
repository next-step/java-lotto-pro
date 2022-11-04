package lotto.winning.ui.inputView;

import java.util.Scanner;

public class WinningNumberInputView {

    public static String readWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner s = new Scanner(System.in);
        return s.nextLine();
    }
}
