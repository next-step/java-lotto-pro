package lotto.view;

import static lotto.constants.LottoGameMessage.*;

import java.util.*;

public class InputView {
    private InputView() {}

    private static final Scanner scanner = new Scanner(System.in);

    public static String inputMoney() {
        System.out.println(WAIT_FOR_USER_MONEY_INPUT);
        return scanner.nextLine();
    }

    public static String inputLatestLottoResult() {
        System.out.println(WAIT_FOR_LATEST_LOTTO_RESULT_INPUT);
        return scanner.nextLine();
    }
}
