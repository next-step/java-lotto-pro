package lotto.view;

import java.util.Scanner;

public class InputView {

    private static final String INSERT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNER_NUMBER_INPUT_MESSAGE = "\n지난 주 당첨 번호를 입력해 주세요.";
    private static final Scanner scanner = new Scanner(System.in);

    public String insertMoney() {
        System.out.println(INSERT_MONEY_MESSAGE);
        return scanner.nextLine();
    }

    public String inputWinnerNumbers() {
        System.out.println(WINNER_NUMBER_INPUT_MESSAGE);
        return scanner.nextLine();
    }
}
