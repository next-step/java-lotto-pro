package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final String ASK_MESSAGE_PAY_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String ASK_MESSAGE_LAST_WINNER_NUMBERS = "\n지난 주 당첨 번호를 입력해 주세요.";
    private static final String WINNER_NUMBERS_DELIMITER = ",";
    private static final String WHITE_SPACE = " ";
    private static final String EMPTY_STRING = "";

    public static int inputPayAmount(){
        Scanner sc = new Scanner(System.in);
        System.out.println(ASK_MESSAGE_PAY_AMOUNT);
        return sc.nextInt();
    }

    public static List<Integer> inputLottoWinnerNumbers(){
        Scanner sc = new Scanner(System.in);
        System.out.println(ASK_MESSAGE_LAST_WINNER_NUMBERS);
        String input = sc.nextLine();
        input = input.replaceAll(WHITE_SPACE, EMPTY_STRING);
        String[] winnerNumbers = input.split(WINNER_NUMBERS_DELIMITER);
        return Arrays.stream(winnerNumbers).map(Integer::parseInt).collect(Collectors.toList());
    }
}
