package lotto.ui.inputView;

import java.util.Scanner;

public class WinningLottoInputView {

    public static final String WINNING_LOTTO_INPUT_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";

    public static String readWinningLotto() {
        System.out.println(WINNING_LOTTO_INPUT_MESSAGE);
        return new Scanner(System.in).nextLine();
    }
}
