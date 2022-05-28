package lotto.view;

import lotto.model.Lotto;
import lotto.model.Lottos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    public static int inputBuyAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return newScanner().nextInt();
    }

    public static int inputManualCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return newScanner().nextInt();
    }

    public static Lottos inputManualNumbers(int repeatCount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<Lotto> result = new ArrayList<>();
        for (int i = 0; i < repeatCount; i++) {
            result.add(new Lotto(newScanner().nextLine()));
        }
        return new Lottos(result);
    }

    public static String inputWinningNumbers() {
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        return newScanner().nextLine();
    }

    public static int inputBonusNumbers() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return newScanner().nextInt();
    }

    private static Scanner newScanner() {
        return new Scanner(System.in);
    }
}
