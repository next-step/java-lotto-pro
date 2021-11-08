package lotto.view;

import lotto.domain.*;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoView {

    private static final String MATCH_RESULT_BONUS = "%d개 일치, 보너스 볼 일치(%d원)- %d개\n";
    private static final String MATCH_RESULT = "%d개 일치 (%d원)- %d개\n";
    private static final int MIN_PROFIT_RATE = 1;
    private static final Scanner scanner = new Scanner(System.in);

    public static Money getMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return new Money(scanner.nextInt());
    }

    public static void displayCount(int count) {
        System.out.printf("%d개를 구매했습니다.\n", count);
    }

    public static void displayCount(Money money) {
        displayCount(money.buy());
    }

    public static void displayLottos(Lottos lottos) {
        lottos.getLottos()
                .forEach(LottoView::displayLotto);
    }

    private static void displayLotto(Lotto lotto) {
        System.out.printf("[ %s ]\n", lotto.toString());
    }

    public static String getWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.next();
    }

    public static void displayStatic(final Result result) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        for (Map.Entry<Rank, Integer> entry : result.getResult().entrySet()) {
            final Rank rank = entry.getKey();;
            System.out.printf(getResultMessage(rank), rank.getCount(), rank.getPrice(), entry.getValue());
        }

        final double rate = result.getProfitRate();

        System.out.printf("총 수익률은 %.2f입니다.", rate);
        if (rate < MIN_PROFIT_RATE) {
            System.out.printf("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
    }

    private static String getResultMessage(Rank rank) {
        if (rank.equals(Rank.SECOND)) {
            return MATCH_RESULT_BONUS;
        }
        return MATCH_RESULT;
    }

    public static Integer getBonusBall() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextInt();
    }

    public static LottoCount getManualCount(Money money) {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return new LottoCount(money, scanner.nextInt());
    }

    public static ManualLottos getManualLottos(LottoCount count) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");

        final List<String> numbers = IntStream.range(0, count.getManualCount())
                .mapToObj(number -> scanner.next())
                .collect(Collectors.toList());
        return new ManualLottos(numbers);
    }
}
