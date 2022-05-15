package lotto.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    private static final String INPUT_PRICE = "구입금액을 입력해 주세요.";
    private static final String INPUT_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";

    public static String inputPrice() {
        System.out.println(INPUT_PRICE);
        return scanner.next();
    }

    public static String inputLottoNumbers() {
        System.out.println(INPUT_NUMBERS);
        return scanner.next();
    }
}
