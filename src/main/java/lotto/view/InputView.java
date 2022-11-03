package lotto.view;

import java.util.Scanner;

public class InputView {

    private static final String ENTER_PURCHASE_AMOUNT = "구매금액을 입력해 주세요.";
    private static final String ENTER_LAST_WEEK_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String ENTER_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";
    private static final String ENTER_MANUAL_LOTTO_COUNT = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String ENTER_MANUAL_LOTTO_NUMBER = "수동으로 구매할 번호를 입력해 주세요.";
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {

    }

    public static String getLottoPurchasePrice() {
        System.out.println(ENTER_PURCHASE_AMOUNT);
        return SCANNER.nextLine();
    }

    public static int getManualLottoCount() {
        try {
            System.out.println();
            System.out.println(ENTER_MANUAL_LOTTO_COUNT);
            return Integer.parseInt(SCANNER.nextLine());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getManualLottoCount();
        }
    }

    public static void manualLottoNumberScript() {
        System.out.println();
        System.out.println(ENTER_MANUAL_LOTTO_NUMBER);
    }

    public static String getManualLottoNumbers() {
        return SCANNER.nextLine();
    }

    public static String getLastWeekWinningNumber() {
        System.out.println();
        System.out.println(ENTER_LAST_WEEK_WINNING_NUMBER);
        return SCANNER.nextLine();
    }

    public static int getBonusNumber() {
        try {
            System.out.println(ENTER_BONUS_NUMBER);
            return Integer.parseInt(SCANNER.nextLine());
        } catch (Exception e) {
            return getBonusNumber();
        }
    }

}
