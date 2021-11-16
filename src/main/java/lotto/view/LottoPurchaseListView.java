package lotto.view;

import lotto.domain.Lottos;

public class LottoPurchaseListView {

    private LottoPurchaseListView() {
    }

    public static void print(Lottos lottos, int manualPurchaseCount) {
        System.out.println();
        System.out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다.", manualPurchaseCount, lottos.purchaseNumber() - manualPurchaseCount);
        System.out.println();

        lottos.purchaseList()
                .forEach(System.out::println);
    }
}
