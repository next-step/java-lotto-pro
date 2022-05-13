package camp.nextstep.edu.step3;

import java.util.Arrays;
import java.util.Scanner;

public class Presenter {
    private final Scanner scanner = new Scanner(System.in);

    public int askPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요\n.");
        return scanner.nextInt();
    }

    public void printPurchaseComplete(final int count) {
        System.out.printf("%d개를 구매했습니다.%n", count);
    }

    public void printLottoList(final LottoPaper paper) {
        System.out.println(paper);
        System.out.println();
    }

    public int[] askLastWeekWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        int[] ints = Arrays.stream(scanner.next().split(",")).mapToInt(Integer::parseInt).toArray();
        System.out.println();
        return ints;
    }

    public String printResult(final Total total, final EarningsRate earningsRate) {
        return new StringBuilder()
                .append(String.format("%s\n", "당첨 통계"))
                .append("---------\n")
                .append(total)
                .append(earningsRate)
                .toString();
    }
}
