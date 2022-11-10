package lotto.ui.inputView;

import java.util.Scanner;

public class BonusBallInputView {

    public static int readBonusBall() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return Integer.parseInt(new Scanner(System.in).nextLine());
    }
}
