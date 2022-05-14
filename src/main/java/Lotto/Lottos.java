package Lotto;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private PurchaseMoney purchaseMoney;
    private PurchaseCount purchaseCount;
    private LottoResult result;
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

    public LottoResult getResult() {
        return result;
    }

    public Lottos(int money) {
        purchaseMoney = new PurchaseMoney(money);
        purchaseCount = new PurchaseCount(purchaseMoney);
        lottos = draw(purchaseCount);
    }

    private List<Lotto> draw(PurchaseCount purchaseCount) {
        List<Lotto> drawLottos = new ArrayList<Lotto>();
        Lotto lotto;
        for(int i = 0; i < purchaseCount.getCount(); i++) {
            lotto = new Lotto();
            drawLottos.add(lotto);
            System.out.println(lotto.toString());
        }
        return drawLottos;
    }

    public void calculation(Lotto winLotto) {
        LottoResult calcResult = new LottoResult();
        for (Lotto lotto : lottos) {
            calcResult.counting(lotto.compare(winLotto));
        }
        calcResult.calculationYield(purchaseMoney);
        result = calcResult;
    }
}
