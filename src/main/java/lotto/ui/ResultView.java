package lotto.ui;

import lotto.common.Constants;
import lotto.domain.PurchasePrice;

/**
 * packageName : lotto.ui
 * fileName : OutputView
 * author : haedoang
 * date : 2021-11-05
 * description :
 */
public class ResultView {

    public static void result(ResultType resultType, Object argument) {
        if(resultType.isPurchase()) {
            printPurchase(argument);
            return;
        }

    }

    private static void printPurchase(Object argument) {
        PurchasePrice price = (PurchasePrice) argument;
        System.out.println(price.toString() + Constants.MSG_OUTPUT_PURCHASE_RESULT_SUFFIX);
    }
}
