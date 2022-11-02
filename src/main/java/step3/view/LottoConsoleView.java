package step3.view;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoConsoleView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static int inputPurchasingAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return SCANNER.nextInt();
    }

    public static String inputWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return SCANNER.next();
    }

    public static int inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return SCANNER.nextInt();
    }

    public static int inputPurchaseManualCount() {
        System.out.println("\n수동으로 구매할 로또 수를 입력해 주세요.");
        return SCANNER.nextInt();
    }

    public static List<String> inputPurchaseManual(int count) {
        if (count > 0) {
            System.out.println("\n수동으로 구매할 번호를 입력해 주세요.");
            return IntStream.rangeClosed(1, count)
                    .mapToObj(operand -> SCANNER.next())
                    .collect(Collectors.toList());
        }
        return Collections.EMPTY_LIST;
    }

}
