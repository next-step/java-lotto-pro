package lotto.view;


import lotto.model.Lotto;
import lotto.model.LottoNumber;
import lotto.model.Rank;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;


public class OutputView {

    public static void outputLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구했습니다.");
        lottos.forEach(OutputView::outputLotts);
    }

    private static void outputLotts(Lotto lotto) {
        String str = lotto.getLottoNumber().stream()
                .map(LottoNumber::getNumber)
                .map(Objects::toString)
                .collect(Collectors.joining(", "));

        System.out.println("[" + str + "]");
    }

    public static void outputResult(Map<Rank, Integer> resultMap) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5000원)- " + resultMap.get(Rank.FIFTH) + "개");
        System.out.println("4개 일치 (50000원)- " + resultMap.get(Rank.FOURTH) + "개");
        System.out.println("5개 일치 (1500000원)- " + resultMap.get(Rank.THIRD) + "개");
        System.out.println("5개 일치 (30000000)- " + resultMap.get(Rank.SECOND) + "개");
        System.out.println("6개 일치 (2000000000원)- " + resultMap.get(Rank.FIRST) + "개");
    }

    public static void outputResultProfit(double profit) {
        System.out.println("총 수익률은 " + profit + "입니다.");
    }
}
