package lotto.view;

import lotto.domain.*;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoView {

    private static final Scanner scanner = new Scanner(System.in);

    public static Money getMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return new Money(scanner.nextInt());
    }

    public static List<Lotto> getLotto(final int count, final RandomNumbers numbers) {
        System.out.println(count + "개를 구매했습니다.");

        return IntStream.range(0, count)
                .mapToObj(number -> new Lotto(numbers.random()))
                .peek(lotto -> System.out.println(lotto.toString()))
                .collect(Collectors.toList());
    }

    public static Lotto getWinningLotto() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return new Lotto(scanner.next());
    }

    public static void getStatic(final List<Lotto> lottos, final Lotto winningLotto, final Money money) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        final List<Rank> ranks = lottos.stream()
                .map(lotto -> Rank.rank(winningLotto.match(lotto)))
                .collect(Collectors.toList());

        final Result result = new Result(ranks, money);

        for (Map.Entry<Rank, Integer> entry : result.getResult().entrySet()) {
            System.out.println(entry.getKey().getCount() + "개 일치 (" + entry.getKey().getPrice() + "원)- " + entry.getValue() +"개");
        }

        final double profitRate = result.getProfitRate();
        System.out.println("총 수익률은 " + profitRate + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)\n");
    }
}
