package lotto.ui.inputView;

import java.util.Scanner;

public class BonusBallInputView {

    public static final String BONUS_BALL_INPUT_MASSAGE = "보너스 볼을 입력해 주세요.";

    public static int readBonusBall() {
        System.out.println(BONUS_BALL_INPUT_MASSAGE);
        return Integer.parseInt(new Scanner(System.in).nextLine());
    }
}
