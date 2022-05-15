package lotto.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static String inputPurchaseAmount() throws IOException {
        System.out.println("구매금액을 입력해 주세요.");
        return br.readLine();
    }

    public static String inputWinningNumbers() throws IOException {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return br.readLine();
    }

}
