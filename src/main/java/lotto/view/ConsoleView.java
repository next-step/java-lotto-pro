package lotto.view;

import lotto.domain.*;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ConsoleView {
    private static final String ENTER_MONEY_TEXT = "구입금액을 입력해 주세요.";
    private static final String ENTER_MANUAL_COUNT_TEXT = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String ENTER_MANUAL_LOTTO_NUMBER_TEXT = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String BUY_LOTTO_TEXT = "수동으로 %d장, 자동으로 %d개를 구매했습니다.";
    private static final String ENTER_WINNING_TEXT = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String ERROR_TEXT = "[ERROR] %s";
    private static final String WINNING_COUNT_TEXT = "%d개 일치%s(%d원)- %d개";
    private static final String REVENUE_PERCENT = "총 수익률은 %.2f입니다.";
    private static Scanner scanner = new Scanner(System.in);

    public static String enterMoney() {
        System.out.println(ENTER_MONEY_TEXT);
        return scanner.nextLine();
    }

    public static String enterManualCount() {
        System.out.println(ENTER_MANUAL_COUNT_TEXT);
        return scanner.nextLine();
    }

    public static void printManualLottoNumber() {
        System.out.println(ENTER_MANUAL_LOTTO_NUMBER_TEXT);
    }

    public static List<String> enterManualLottoNumber(int manualCount) {
        return IntStream.range(0, manualCount)
                .mapToObj(i -> scanner.nextLine())
                .collect(Collectors.toList());
    }

    public static void printBoughtLottoCount(BoughtLotto boughtLotto) {
        System.out.printf(BUY_LOTTO_TEXT, boughtLotto.getManualCount(), boughtLotto.getAutoCount());
        printLine();
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

    public static void printWinning(WinningMap winningMap) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        Map<Rank, Integer> map = winningMap.getWinningMap();
        for (Rank rank : Rank.excludedMissList()) {
            System.out.printf(WINNING_COUNT_TEXT, rank.getCountOfMatch(), printSecondRank(rank), rank.getWinningMoney(), map.getOrDefault(rank, 0));
            printLine();
        }
    }

    private static String printSecondRank(Rank rank) {
        if (rank.equals(Rank.SECOND)) {
            return ", 보너스 볼 일치";
        }

        return "";
    }

    public static int enterBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public static void printRevenue(double revenue) {
        System.out.printf(REVENUE_PERCENT, revenue);
    }

    public static void printLine() {
        System.out.println();
    }

}
