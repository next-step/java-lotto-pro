package play.ui;

import java.util.Map;
import play.domain.Lotto;
import play.domain.LottoResult;
import play.domain.Lottos;
import play.domain.Rank;

public class OutputView {
    public static void printCompletePurchaseLotto(Lottos lottos) {
        System.out.println(lottos.getLottoList().size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos.getLottoList()) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printResultHead() {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
    }

    public static void printLottoResult(LottoResult lottoResult) {
        Map<Rank, Integer> resultMap = lottoResult.getResultMap();
        for (Rank rank : resultMap.keySet()) {
            if (lottoResult.isValidNothing(rank)) {
                continue;
            }
            printResult(rank, resultMap.get(rank));
        }
        System.out.println(lottoResult.convertYieldToString());
    }

    private static void printResult(Rank rank, Integer count) {
        System.out.printf("%d개 일치 (%d원)- %d개%n", rank.containsCount(), rank.getMoney(), count);
    }

}
