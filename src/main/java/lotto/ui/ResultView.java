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

    public static void printPurchaseResult(int manual, int automatic) {
        System.out.printf(Constants.MSG_OUTPUT_PURCHASE_RESULT, manual, automatic);
    }

    public static void printPurchasedLotto(Lottos lottos) {
        lottos.getPrintBallList().stream().forEach(str -> System.out.println(StringUtil.wrap(str)));
    }

    public static void printLottoResult(Ranks ranks) {
        System.out.println(Constants.MSG_OUTPUT_LOTTO_RESULT);
        System.out.println(Constants.MSG_OUTPUT_LINE_SEPARATOR);
        System.out.printf(Constants.MSG_OUTPUT_PLACE, Rank.FIFTH.getCountOfMatch(), Rank.FIFTH.getWinningMoney(), ranks.countPlace(Rank.FIFTH));
        System.out.printf(Constants.MSG_OUTPUT_PLACE, Rank.FOURTH.getCountOfMatch(), Rank.FOURTH.getWinningMoney(), ranks.countPlace(Rank.FOURTH));
        System.out.printf(Constants.MSG_OUTPUT_PLACE, Rank.THIRD.getCountOfMatch(), Rank.THIRD.getWinningMoney(), ranks.countPlace(Rank.THIRD));
        System.out.printf(Constants.MSG_OUTPUT_PLACE_WITH_BONUS, Rank.SECOND.getCountOfMatch(), Rank.SECOND.getWinningMoney(), ranks.countPlace(Rank.SECOND));
        System.out.printf(Constants.MSG_OUTPUT_PLACE, Rank.FIRST.getCountOfMatch(), Rank.FIRST.getWinningMoney(), ranks.countPlace(Rank.FIRST));
        System.out.printf(Constants.MSG_OUTPUT_YIELD, ranks.earningRatio());
    }

}
