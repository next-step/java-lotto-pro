package Lotto;

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
        lottos = draw(purchaseCount);
    }

    private List<Lotto> draw(PurchaseCount purchaseCount) {
        List<Lotto> drawLottos = new ArrayList<Lotto>();
        for(int i = 0; i < purchaseCount.getCount() ; i++) {
            drawLottos.add(new Lotto());
        }
        return drawLottos;
    }
}
