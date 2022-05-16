package lotto.view;

import lotto.constant.ViewMessageConst;

import java.util.Scanner;

public class InputView {
    private static final Scanner scan = new Scanner(System.in);

    public static String readMoney(){
        System.out.println(ViewMessageConst.INPUT_MESSAGE_PURCHASE_MONEY);
        return scan.nextLine();
    }

    public static String readLottoWinningNumber() {
        System.out.println(ViewMessageConst.INPUT_MESSAGE_WINNING_NUMBER);
        return scan.nextLine();
    }
}
