package lotto.view;

import lotto.constant.Message;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public final class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {}

    public static int inputTotalPayment() {
        System.out.println(Message.INPUT_TOTAL_PAYMENT);
        return Integer.parseInt(scanner.nextLine());
    }

    public static String inputLastWeekWinningLottoLine() {
        System.out.println(Message.INPUT_LAST_WEEK_WINNING_LOTTO_LINE);
        return scanner.nextLine();
    }

    public static int inputBonusNumber(){
        System.out.println(Message.INPUT_BONUS_NUMBER);
        return Integer.parseInt(scanner.nextLine());
    }
}
