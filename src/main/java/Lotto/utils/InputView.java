package Lotto.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public static List<String> inputManualLottoNumber(int count) {
        System.out.println("수동으로 구매 할 번호를 번호를 입력해 주세요.");
        List<String> result = new ArrayList<>();
        scanner.nextLine();
        for(int i = 0; i < count; i++)
            result.add(scanner.nextLine());
        return result;
    }

    public static String inputLastWinNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

    public static String inputLastWinBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextLine();
    }

    public static int inputManualLottoCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return scanner.nextInt();
    }
}
