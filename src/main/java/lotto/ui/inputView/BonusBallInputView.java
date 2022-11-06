package lotto.ui.inputView;

import java.util.Scanner;

public class BonusBallInputView {

    public static String readBonusBall() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return new Scanner(System.in).nextLine();
    }
}
