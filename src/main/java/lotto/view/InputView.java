package lotto.view;

import lotto.constant.Message;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputTotalPayment() {
        System.out.println(Message.INPUT_TOTAL_PAYMENT);
        return Integer.parseInt(scanner.nextLine());
    }

    public static String inputLastWeekWinningLottoLine() {
        System.out.println(Message.INPUT_LAST_WEEK_WINNING_LOTTO_LINE);
        return scanner.nextLine();
    }
}
