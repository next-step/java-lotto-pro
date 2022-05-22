package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static String readMoney() {
        System.out.println("구입 금액을 입력해 주세요. (자연수만 가능하며, 1게임 가격에 따라 구입 개수가 정해짐)");
        return scanner.nextLine();
    }

    public static String readNumberOfManualLottoGames() {
        System.out.println();
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return scanner.nextLine();
    }

    public static List<String> readManualLottoGames(int numberOfManual) {
        System.out.println();
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<String> games = new ArrayList<>();
        for (int i = 0; i < numberOfManual; i++) {
            games.add(scanner.nextLine());
        }
        return games;
    }

    public static String readWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요. (','로 구분)");
        return scanner.nextLine();
    }

    public static String readBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return scanner.nextLine();
    }
}
