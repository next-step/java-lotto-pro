package lotto.ui;

import java.util.ArrayList;
import java.util.List;
import nextstep.utils.Console;

public class InputView {

    public static String askPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요");
        return Console.readLine();
    }

    public static String askNumberOfManuals() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return Console.readLine();
    }

    public static List<String> askEnterNumbers(final int numberOfPlayslips) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        final List<String> numbers = new ArrayList<>();
        for (int i = 0; i < numberOfPlayslips; i++) {
            numbers.add(Console.readLine());
        }
        return numbers;
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
