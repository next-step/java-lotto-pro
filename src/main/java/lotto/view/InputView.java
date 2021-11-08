package lotto.view;

import lotto.LotteryCalculator;
import lotto.Money;

import java.util.List;
import java.util.Scanner;

public class InputView {
    public static final String ENTER_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    public static final String NUMBER_OF_LOTTO_TICKET = "개를 구매했습니다.";
    public static final String ENTER_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    public static final String DELIMITER = ", ";

    public static int payMoney() {
        Scanner sc = new Scanner(System.in);
        System.out.println(ENTER_PURCHASE_AMOUNT);
        int numberOfTicket = LotteryCalculator.calculateTicket(new Money(sc.nextInt()));
        System.out.println(numberOfTicket + NUMBER_OF_LOTTO_TICKET);
        return numberOfTicket;
    }

    public static void printLottoTicketNumber(List<Integer> lottoTicket) {
        System.out.println(lottoTicket);
    }

    public static String[] enterWinningNumber() {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println(ENTER_WINNING_NUMBER);
        return sc.nextLine().split(DELIMITER);
    }
}
