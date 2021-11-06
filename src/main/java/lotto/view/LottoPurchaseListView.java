package lotto.view;

import lotto.domain.Lottos;

public class LottoPurchaseListView {

    private LottoPurchaseListView() {
    }

    public static void print(Lottos lottos) {
        System.out.print(lottos.purchaseNumber()+ "개를 구매했습니다.");
        System.out.println();

        lottos.purchaseList().stream().forEach(System.out::println);
    }
}
