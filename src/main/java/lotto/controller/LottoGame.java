package lotto.controller;

import lotto.domain.*;

import java.util.*;

public class LottoGame {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        Money money = new Money(scanner.nextInt());

        System.out.println(money.buy() + "개를 구매했습니다.");
        List<Lotto> lottos = new ArrayList<>();
        RandomNumbers randomNumbers = new RandomNumbers(new RandomNumber());
        for (int i = 0; i < money.buy(); i++) {
            List<Integer> random = randomNumbers.random();
            Lotto lotto = new Lotto(random);
            lottos.add(lotto);
            System.out.println(lotto.toString());
        }
        System.out.println();

        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String numbers = scanner.next();
        Lotto winningLotto = new Lotto(numbers);
        System.out.println();

        System.out.println("당첨 통계");
        System.out.println("---------");

        List<Rank> ranks = new ArrayList<>();
        for (Lotto lotto : lottos) {
            int match = winningLotto.match(lotto);
            ranks.add(Rank.rank(match));
        }

        Result result = new Result(ranks, money);
        Map<Rank, Integer> map = result.getResult();
        for (Map.Entry<Rank, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey().getCount() + "개 일치 (" + entry.getKey().getPrice() + "원)- " + entry.getValue() +"개");
        }
        double profitRate = result.getProfitRate();
        System.out.println("총 수익률은 " + profitRate + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)\n");
    }
}
