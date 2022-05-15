package Lotto.utils;

import Lotto.Lotto;
import Lotto.Lottos;
import Lotto.LottoResult;
import Lotto.PurchaseCount;

import java.util.List;

public class ResultView {
    public static void purchaseList (Lottos lottos) {
        for(Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.toString());
        }
        System.out.println();
    }

    public static void result (LottoResult result) {
        System.out.println("당첨통계");
        System.out.println("---------");

        System.out.println("3개 일치 (5000원)- " + result.getFourthCount() + "개");
        System.out.println("4개 일치 (50000원)- " + result.getThirdCount() + "개");
        System.out.println("5개 일치 (1500000원)- " + result.getSecondCount() + "개");
        System.out.println("6개 일치 (2000000000원)- " + result.getFirstCount() + "개");
        System.out.println("총 수익률은 " + result.getYield().getYield() + "입니다.");
    }

    public static void printPurchaseInfo(PurchaseCount purchaseCount) {
        System.out.println(purchaseCount.getCount() + "개를 구매했습니다.");
    }

    public static void printLottoNumbers(List<Lotto> lottos) {
        for(Lotto lotto : lottos)
            System.out.println(lotto.toString());
    }
}
