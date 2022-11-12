package lotto.view;

import java.util.List;
import java.util.StringJoiner;
import lotto.model.constants.LottoConstants;
import lotto.model.domain.Lotto;
import lotto.model.domain.LottoNumber;
import lotto.model.domain.Lottos;
import lotto.model.domain.Profit;
import lotto.model.domain.PurchaseInfo;
import lotto.model.domain.WinCriterion;
import lotto.model.domain.WinResult;
import lotto.model.dto.LottoResult;
import utils.MoneyFormat;

public class ResultView {

    public void printPurchaseCount(PurchaseInfo purchaseInfo) {
        System.out.print("수동으로 " + purchaseInfo.getManualLottoCount() + "장");
        System.out.println(", 자동으로 " + purchaseInfo.getAutoLottoCount() + "개를 구매했습니다.");
    }

    public void printLottos(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            printLotto(lotto);
        }
        System.out.println();
    }

    public void printLotto(Lotto lotto) {
        System.out.print(LottoConstants.LOTTO_PRINT_START);
        StringJoiner sj = new StringJoiner(LottoConstants.LOTTO_PRINT_DELIMITER);
        for (LottoNumber lottoNumber : lotto.getLotto()) {
            sj.add(lottoNumber.getLottoNumber() + "");
        }
        System.out.print(sj);
        System.out.println(LottoConstants.LOTTO_PRINT_END);
    }

    public void printLottoResult(LottoResult lottoResult) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        printWinResult(lottoResult.getWinResult());
        printProfit(lottoResult.getProfit());
    }

    private void printWinResult(WinResult winResult) {
        List<WinCriterion> winCriteria = winResult.getWinCriterionFromWinResult();
        for (WinCriterion winCriterion : winCriteria) {
            printWinCriteria(winCriterion);
            System.out.println("- " + winResult.getCountByWinCriterion(winCriterion) + "개");
        }
    }

    private void printWinCriteria(WinCriterion winCriterion) {
        //, 보너스 볼 일치
        String criterionExpression = winCriterion.getMatchCount() + "개 일치";
        if (winCriterion.checkBonusMatch()) {
            criterionExpression += ", 보너스 볼 일치";
        }
        criterionExpression += " (" + MoneyFormat.getMoneyExpression(winCriterion.getPrize()) + "원)";
        System.out.print(criterionExpression);
    }

    private void printProfit(Profit profit) {
        System.out.print("총 수익률은 " + profit.getProfit() + "입니다.");
        if (profit.getProfit() < 1) {
            System.out.print("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
        System.out.println();
    }

}
