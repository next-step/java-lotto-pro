package lotto.ui;

import static java.lang.Integer.parseInt;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;
import lotto.ui.dto.MatchingCount;
import lotto.ui.dto.WinningNumbersInput;
import lotto.ui.dto.WinningStatisticsOutput;

public class WinningStatisticsView {
    private static final Scanner scanner = new Scanner(System.in);

    private static final LottoNumberReader lottoNumberReader = new LottoNumberReader(scanner);

    public static WinningNumbersInput receiveWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        final List<Integer> winningNumbers = readWinningNumbers();

        System.out.println("보너스 볼을 입력해 주세요.");
        final int bonus = readBonus();

        return new WinningNumbersInput(winningNumbers, bonus);
    }

    private static List<Integer> readWinningNumbers() {
        return lottoNumberReader.readLottoNumbers();
    }

    private static int readBonus() {
        try {
            return readPositiveInt();
        } catch (NumberFormatException e) {
            System.out.println("정수를 입력해 주세요.");
            return readBonus();
        }
    }

    private static int readPositiveInt() {
        final String nextLine = scanner.nextLine();

        final int integer = parseInt(nextLine);

        if (integer < 0) {
            System.out.println("양수를 입력해 주세요.");
            return readPositiveInt();
        }

        return integer;
    }

    public static void printResult(WinningStatisticsOutput output) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        printMatchingCount(output.getMatchingCounts());
        printReturnOnInvestment(output.getReturnOnInvestment());
    }

    private static void printMatchingCount(List<MatchingCount> matchingCounts) {
        matchingCounts.stream()
                .filter(MatchingCount::isDisplayed)
                .forEach(System.out::println);
    }

    private static void printReturnOnInvestment(BigDecimal returnOnInvestment) {
        System.out.println("총 수익률은 " + returnOnInvestment + "입니다.");
    }
}
