package lotto.view;

import lotto.domain.LottoManual;
import lotto.domain.Lottos;

public class LottoPurchaseListView {

    private LottoPurchaseListView() {
    }

    public static void print(Lottos lottos, LottoManual lottoManual) {
        System.out.println();
        System.out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다.", lottoManual.getPurchaseCount(), lottos.purchaseNumber() - lottoManual.getPurchaseCount());
        System.out.println();

        lottos.purchaseList()
                .forEach(System.out::println);
    }
}
