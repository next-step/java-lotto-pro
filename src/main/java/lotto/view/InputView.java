package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String ENTER_GAME_MONEY = "구입금액을 입력해 주세요.";
    private static final String ENTER_WINNER_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String ENTER_BONUS_BALL = "보너스 볼을 입력해 주세요.";

    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static void printEnterGameMoney() {
        System.out.println(ENTER_GAME_MONEY);
    }

    public static void printEnterWinnerNumber() {
        System.out.println(ENTER_WINNER_NUMBER);
    }

    public static void printEnterBonusBall() {
        System.out.println(ENTER_BONUS_BALL);
    }

    public static int scanGameMoney() {
        return scanner.nextInt();
    }

    public static List<Integer> scanWinnerNumber() {
        clearScannerBuffer();
        String winnerNumbers = scanner.nextLine();
        List<Integer> winnerNumber = splitWinnerNumber(winnerNumbers);
        // todo validate winnerNumber
        return winnerNumber;
    }

    private static List<Integer> splitWinnerNumber(String winnerNumbers) {
        String[] split = winnerNumbers.split("\\s*,\\s*");
        return Arrays.stream(split)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static void clearScannerBuffer() {
        scanner.nextLine();
    }

    public static Integer scanBonusBall() {
        return scanner.nextInt();
    }
}
