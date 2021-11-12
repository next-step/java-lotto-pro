package lotto.view;

import lotto.LotteryCalculator;
import lotto.Money;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String ENTER_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String ENTER_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String ENTER_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";
    private static final String DELIMITER = ", ";
    private static final String ENTER_NUMBER_OF_MANUAL_LOTTERY_TICKETS = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String ENTER_MANUAL_LOTTERY_NUMBERS = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String NUMBER_OF_LOTTERY_TICKET_TYPE = "수동으로 %d장, 자동으로 %d개를 구매했습니다.";

    public static int payMoney() {
        Scanner sc = new Scanner(System.in);
        System.out.println(ENTER_PURCHASE_AMOUNT);
        return LotteryCalculator.calculateTicket(new Money(sc.nextInt()));
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

    public static int enterBonusNumber() {
        Scanner sc = new Scanner(System.in);
        System.out.println(ENTER_BONUS_NUMBER);
        return sc.nextInt();
    }

    public static int enterNumberOfManualLotteryTickets() {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println(ENTER_NUMBER_OF_MANUAL_LOTTERY_TICKETS);
        return sc.nextInt();
    }

    public static String[] enterManualLotteryNumbers() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine().split(DELIMITER);
    }

    public static void printLotteryTicketType(int numberOfManualTicket, int numberOfAutoTickets) {
        System.out.println();
        System.out.println(String.format(NUMBER_OF_LOTTERY_TICKET_TYPE, numberOfManualTicket, numberOfAutoTickets));
    }

    public static void enterManualLotteryNumbersMessage() {
        System.out.println();
        System.out.println(ENTER_MANUAL_LOTTERY_NUMBERS);
    }
}
