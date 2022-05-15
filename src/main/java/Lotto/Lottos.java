package Lotto;

import Lotto.utils.InputView;
import Lotto.utils.ResultView;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private PurchaseMoney purchaseMoney;
    private PurchaseCount purchaseCount;
    private List<Lotto> lottos;

    public PurchaseMoney getPurchaseMoney() {
        return purchaseMoney;
    }

    public PurchaseCount getPurchaseCount() {
        return purchaseCount;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public Lottos(int money) {
        purchaseMoney = new PurchaseMoney(money);
        purchaseCount = new PurchaseCount(purchaseMoney);
        ResultView.printPurchaseInfo(purchaseCount);
        lottos = draw(purchaseCount);
    }

    private List<Lotto> draw(PurchaseCount purchaseCount) {
        List<Lotto> drawLottos = new ArrayList<Lotto>();
        Lotto lotto;
        for(int i = 0; i < purchaseCount.getCount(); i++) {
            lotto = new Lotto();
            drawLottos.add(lotto);
        }
        ResultView.printLottoNumbers(drawLottos);
        return drawLottos;
    }

    public LottoResult calculation(Lotto winLotto) {
        LottoResult calcResult = new LottoResult();
        for (Lotto lotto : lottos) {
            calcResult.counting(lotto.compare(winLotto));
        }
        calcResult.calculationYield(purchaseMoney);
        return calcResult;
    }
}
