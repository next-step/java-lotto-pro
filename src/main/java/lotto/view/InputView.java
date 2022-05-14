package lotto.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {
    private static final String START_LOTTO = "구입금액을 입력해주세요.";

    public String printStart() throws IOException {
        System.out.println(START_LOTTO);
        return input();
    }

    private String input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();
    }
}
