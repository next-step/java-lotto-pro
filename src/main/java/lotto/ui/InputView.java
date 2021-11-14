package lotto.ui;

import nextstep.utils.Console;

public class InputView {

    public static String askPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요");
        return Console.readLine();
    }

    public static String askPastWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public static String askBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return Console.readLine();
    }
}
