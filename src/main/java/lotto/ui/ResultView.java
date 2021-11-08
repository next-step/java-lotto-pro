package lotto.ui;

import lotto.common.Constants;
import lotto.common.utils.StringUtil;
import lotto.domain.Lottos;
import lotto.domain.PurchasePrice;
import lotto.domain.Rank;
import lotto.domain.Ranks;

/**
 * packageName : lotto.ui
 * fileName : OutputView
 * author : haedoang
 * date : 2021-11-05
 * description : 출력 클래스
 */
public class ResultView {
    private ResultView() {
    }

    public static void print(String msg) {
        System.out.println(msg);
    }

    public static void printPurchaseResult(PurchasePrice price) {
        System.out.println(price.calculateQuantity() + Constants.MSG_OUTPUT_PURCHASE_RESULT_SUFFIX);
    }

    public static void printPurchasedLotto(Lottos lottos) {
        lottos.getPrintBallList().stream().forEach(str -> System.out.println(StringUtil.wrap(str)));
    }

    public static void printLottoResult(Ranks ranks) {
        System.out.println(Constants.MSG_OUTPUT_LOTTO_RESULT);
        System.out.println(Constants.MSG_OUTPUT_LINE_SEPARATOR);
        System.out.println(ranks.getPlaceMessage(Rank.FIFTH));
        System.out.println(ranks.getPlaceMessage(Rank.FOURTH));
        System.out.println(ranks.getPlaceMessage(Rank.THIRD));
        System.out.println(ranks.getPlaceMessage(Rank.SECOND));
        System.out.println(ranks.getPlaceMessage(Rank.FIRST));
        System.out.println(Constants.MSG_OUTPUT_YIELD_PREFIX + ranks.earningRatio() + Constants.MSG_OUTPUT_YIELD_SUFFIX);
    }

}
