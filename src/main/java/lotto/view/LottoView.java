package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.Rank;
import lotto.domain.Result;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class LottoView {

    private static final Scanner scanner = new Scanner(System.in);

    public static Money getMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return new Money(scanner.nextInt());
    }

    public static void displayCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void displayLottos(List<Lotto> lottos) {
        lottos.stream()
                .forEach(LottoView::displayLotto);
    }

    private static void displayLotto(Lotto lotto) {
        System.out.println(lotto.toString());
    }

    public static Lotto getWinningLotto() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return new Lotto(scanner.next());
    }

    public static void displayStatic(final Result result) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        for (Map.Entry<Rank, Integer> entry : result.getResult().entrySet()) {
            System.out.println(entry.getKey().getCount() + "개 일치 (" + entry.getKey().getPrice() + "원)- " + entry.getValue() +"개");
        }

        System.out.println("총 수익률은 " + result.getProfitRate() + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)\n");
    }
}
