package lotto.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static Integer getPurchaseMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return parseInt(scanner.nextLine());
    }

    public static String getWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

    public static Integer getBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return parseInt(scanner.nextLine());
    }

    public static Integer getManualCount() {
        System.out.println();
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int count = parseInt(scanner.nextLine());
        if (count < 0) {
            throw new IllegalArgumentException("수동 구매 로또 수는 음수가 될 수 없습니다.");
        }
        return count;
    }

    private static int parseInt(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력값을 확인해주세요. 숫자만 입력 가능합니다.", e);
        }
    }

    public static List<String> getManualLottoNumbers(Integer manualCount) {
        if (manualCount == 0) {
            return Collections.emptyList();
        }
        System.out.println();
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<String> list = new ArrayList<>();
        for (int i = 0; i < manualCount; i++) {
            list.add(scanner.nextLine());
        }
        return list;
    }
}
