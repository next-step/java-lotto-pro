package lotto.view;

import java.util.Arrays;
import java.util.Scanner;

public class InputView {
    private static final String ENTER_GAME_MONEY = "구입금액을 입력해 주세요.";
    private static final String RESULT_PURCHASE = "%d개를 구매했습니다.";
    private static final String ENTER_WINNER_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";

    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static void printEnterGameMoney() {
        System.out.println(ENTER_GAME_MONEY);
    }

    public static void printResultPurchase(int count) {
        System.out.printf(RESULT_PURCHASE + System.lineSeparator(), count);
    }

    public static void printEnterWinnerNumber() {
        System.out.println(ENTER_WINNER_NUMBER);
    }

    public static int scanGameMoney() {
        clearScannerBuffer();
        int gameMoney = scanner.nextInt();
        // todo validate gameMoney
        return gameMoney;
    }

    public static int[] scanWinnerNumber() {
        clearScannerBuffer();
        String winnerNumbers = scanner.nextLine();
        int[] winnerNumber = splitWinnerNumber(winnerNumbers);
        // todo validate winnerNumber
        return winnerNumber;
    }

    private static int[] splitWinnerNumber(String winnerNumbers) {
        String[] split = winnerNumbers.split("\\s*,\\s*");
        return Arrays.stream(split)
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static void clearScannerBuffer() {
        scanner.nextLine();
    }
}
