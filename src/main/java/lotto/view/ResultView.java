package lotto.view;

import lotto.model.dto.LottoResult;
import lotto.model.vo.Lottos;
import lotto.model.vo.Profit;
import lotto.model.vo.PurchaseCount;
import lotto.model.vo.WinResult;

public class ResultView {

    public void printPurchaseCount(PurchaseCount purchaseCount) {
        System.out.println(purchaseCount.getPurchaseCount() + "개를 구매했습니다.");
    }

    public void printLotto(Lottos lottos) {
        lottos.print();
        System.out.println();
    }

    public void printLottoResult(LottoResult lottoResult) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        printWinResult(lottoResult.getWinResult());
        printProfit(lottoResult.getProfit());
    }

    private void printWinResult(WinResult winResult) {
        winResult.print();
    }

    private void printProfit(Profit profit) {
        profit.print();
    }

}
