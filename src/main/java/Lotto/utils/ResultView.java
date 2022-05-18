package Lotto.utils;

import Lotto.Lotto;
import Lotto.Lottos;
import Lotto.LottoResult;
import Lotto.enums.CompareEnum;

import java.util.Map;
import java.util.Objects;

public class ResultView {
    public static void purchaseList (Lottos lottos) {
        for(Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.toString());
        }
        System.out.println();
    }

    public static void result (LottoResult result) {
        Map<CompareEnum, Integer> hitList = result.getHitList();

        System.out.println("당첨통계");
        System.out.println("---------");

        System.out.println("3개 일치 (5000원)- " + getHitCount(hitList, CompareEnum.Fifth) + "개");
        System.out.println("4개 일치 (50000원)- " + getHitCount(hitList, CompareEnum.Fourth) + "개");
        System.out.println("5개 일치 (1500000원)- " + getHitCount(hitList, CompareEnum.Third) + "개");
        System.out.println("5개 일치, 보너스 볼 일치(30000000원)- " + getHitCount(hitList, CompareEnum.Second) + "개");
        System.out.println("6개 일치 (2000000000원)- " + getHitCount(hitList, CompareEnum.First) + "개");
        System.out.println("총 수익률은 " + result.getYield().getYield() + "입니다.");
    }

    public static void printPurchaseLottos(Lottos lottos) {
        System.out.println(lottos.getPurchaseCount().getCount() + "개를 구매했습니다.");
        for(Lotto lotto : lottos.getLottos())
            System.out.println(lotto.toString());
    }

    private static int getHitCount(Map<CompareEnum, Integer> hitList, CompareEnum compareEnum) {
        if(Objects.isNull(hitList.get(compareEnum)))
            return 0;
        return hitList.get(compareEnum);
    }
}
