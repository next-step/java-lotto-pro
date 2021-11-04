package lotto.view;

import lotto.domain.LottoNumbers;
import lotto.domain.LottoTicket;

import java.util.List;
import java.util.Scanner;

public class ConsoleView {
    private static final String ENTER_MONEY_TEXT = "구입금액을 입력해 주세요.";
    private static final String BUY_LOTTO_TEXT = "%d개를 구매했습니다." + System.lineSeparator();
    private static final String ENTER_WINNING_TEXT = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String ERROR_TEXT = "[ERROR] %s";
    private static Scanner scanner = new Scanner(System.in);

    public static String enterMoney() {
        System.out.println(ENTER_MONEY_TEXT);
        return scanner.nextLine();
    }

    public static void printBoughtLotto(int boughtCount) {
        System.out.printf(BUY_LOTTO_TEXT, boughtCount);
    }

    public static void printLottoTicket(LottoTicket lottoTicket) {
        List<LottoNumbers> ticket = lottoTicket.getTicket();
        ticket.stream().forEach(System.out::println);
    }

    public static String enterWinning() {
        System.out.println(ENTER_WINNING_TEXT);
        return scanner.nextLine();
    }

    public static void printError(String errorMessage) {
        System.out.printf(ERROR_TEXT, errorMessage);
        printLine();
    }

    public static void printLine() {
        System.out.println();
    }

}
