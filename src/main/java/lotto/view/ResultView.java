package lotto.view;

import lotto.domain.Lotties;

public class ResultView {
    public static void printPurchaseLotties(Lotties myLotties) {
        System.out.printf("%d개를 구매했습니다.%n", myLotties.count());
        myLotties.printLotties();
        System.out.println();
    }
}
