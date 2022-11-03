package step3.view;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ConsoleInputView {
    private final static Scanner SCANNER = new Scanner(System.in);
    private static final String ENTER_THE_PURCHASE_AMOUNT = "구입 금액을 입력해주세요.";
    private static final String ENTER_THE_LAST_WEEK_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해주세요.";
    private static final String ENTER_THE_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";
    private static final String ENTER_THE_MANUAL_LOTTO_COUNT = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String ENTER_THE_MANUAL_LOTTO_NUMBERS = "수동으로 구매할 번호를 입력해 주세요.";

    private ConsoleInputView() {

    }

    public static Long receivePurchaseAmount() {
        System.out.println(ENTER_THE_PURCHASE_AMOUNT);
        return SCANNER.nextLong();
    }

    public static String receiveWinningNumber() {
        System.out.println(ENTER_THE_LAST_WEEK_WINNING_NUMBERS);
        return SCANNER.nextLine();
    }

    public static int receiveBonusNumber() {
        System.out.println(ENTER_THE_BONUS_NUMBER);
        return SCANNER.nextInt();
    }

    public static int receiveManualLottoCount() {
        System.out.println(ENTER_THE_MANUAL_LOTTO_COUNT);
        SCANNER.nextLine();
        return SCANNER.nextInt();
    }

    public static List<String> receiveManualLottoNumbers(int purchaseCount) {
        System.out.println(ENTER_THE_MANUAL_LOTTO_NUMBERS);
        SCANNER.nextLine();
        return IntStream.range(0, purchaseCount)
                .mapToObj(it -> SCANNER.nextLine())
                .collect(Collectors.toList());
    }
}
