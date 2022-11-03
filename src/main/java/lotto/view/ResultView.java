package lotto.view;

import lotto.model.dto.LottoResult;
import lotto.model.vo.Lottos;
import lotto.model.vo.PurchaseCount;

public class ResultView {

    public void printPurchaseCount(PurchaseCount purchaseCount) {
        System.out.println(purchaseCount.getPurchaseCount()+"개를 구매했습니다.");
    }

    public void printLotto(Lottos lottos) {
        lottos.print();
    }

    public void printLottoResult(LottoResult lottoResult) {
    }
}
