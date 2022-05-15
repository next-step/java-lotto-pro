package lotto.view;

import java.util.Scanner;

public class InputView {
    public static final String INPUT_PURCHASE_PRICE_MESSAGE = "구입금액을 입력해주세요.";
    public static final String INPUT_CHECK_WINNING_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해주세요.";

    private Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public void printInputPurchasePrice() {
        System.out.println(INPUT_PURCHASE_PRICE_MESSAGE);
    }

    public String inputPurchasePrice() {
        return scanner.nextLine();
    }

    public void printInputLastWeekWinningNumber() {
        System.out.println(INPUT_CHECK_WINNING_NUMBER_MESSAGE);
    }

    public String inputLastWeekWinningNumber() {
        return scanner.nextLine();
    }
}
