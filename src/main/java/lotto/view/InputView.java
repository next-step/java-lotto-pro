package lotto.view;

import java.util.List;
import java.util.Scanner;
import lotto.model.lotto.Lotto;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static String inputPurchasedMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextLine();
    }

    public static String inputWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

    public static String inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextLine();
    }

    public static int inputPurchaseManualCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public static void inputPurchaseManualLotto() {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
    }

    public static String inputEmptyAsk() {
        return scanner.nextLine();
    }

}
