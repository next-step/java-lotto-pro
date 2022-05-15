package lotto.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {
    private static final String START_LOTTO = "구입금액을 입력해주세요.";
    private static final String WINNING_LOTTO = "지난 주 당첨 번호를 입력해 주세요.";

    public String printStart() throws IOException {
        System.out.println(START_LOTTO);
        return input();
    }

    public String printWinningLotto() throws IOException {
        System.out.println("\n" + WINNING_LOTTO);
        return input();
    }

    private String input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();
    }
}
