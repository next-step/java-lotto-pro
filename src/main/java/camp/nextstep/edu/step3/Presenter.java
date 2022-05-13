package camp.nextstep.edu.step3;

import java.util.Arrays;
import java.util.Scanner;

public class Presenter {

    public int askPurchaseAmount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public void printLottoList(final LottoPaper paper) {
        System.out.printf("%d개를 구매했습니다.%n", paper.numberOfPurchases());
        System.out.println(paper);
    }

    public int[] askLastWeekWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        int[] ints = Arrays.stream(scanner.nextLine().replace(" ", "").split(",")).mapToInt(Integer::parseInt).toArray();
        System.out.println();
        return ints;
    }

    public void printResult(final Total total, final EarningsRate earningsRate) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.print(total);
        System.out.println(earningsRate);
    }
}
