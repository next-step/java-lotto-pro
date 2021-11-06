package lotto.view;

import lotto.domain.*;

import java.util.Map;
import java.util.Scanner;

public class LottoView {

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

    public static Lotto getWinningLotto() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return new Lotto(scanner.next());
    }

    public static void displayStatic(final Result result) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        for (Map.Entry<Rank, Integer> entry : result.getResult().entrySet()) {
            System.out.printf("%d개 일치 (%d원)- %d개\n", entry.getKey().getCount(), entry.getKey().getPrice(), entry.getValue());
        }

        final double rate = result.getProfitRate();
        System.out.printf("총 수익률은 %.2f입니다.", rate);
        if (rate < MIN_PROFIT_RATE) {
            System.out.printf("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
    }

    public static Bonus getBonusBall() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return new Bonus(scanner.nextInt());
    }
}
