package Lotto;

import Lotto.utils.InputView;
import Lotto.utils.ResultView;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private PurchaseMoney purchaseMoney = new PurchaseMoney();
    private PurchaseCount purchaseCount;
    private List<Lotto> lottos = new ArrayList<Lotto>();

    public PurchaseMoney getPurchaseMoney() {
        return purchaseMoney;
    }

    public PurchaseCount getPurchaseCount() {
        return purchaseCount;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public Lottos() {
    }

    public Lottos(int money) {
        if(money == 0)
            return;

        purchaseMoney = new PurchaseMoney(money);
        purchaseCount = new PurchaseCount(purchaseMoney);
        lottos = draw(purchaseCount);
    }

    public Lottos(int money, List<Lotto> lottos) {
        purchaseMoney = new PurchaseMoney(money);
        purchaseCount = new PurchaseCount(purchaseMoney);
        this.lottos = lottos;
    }

    private List<Lotto> draw(PurchaseCount purchaseCount) {
        List<Lotto> drawLottos = new ArrayList<Lotto>();
        Lotto lotto;
        for(int i = 0; i < purchaseCount.getCount(); i++) {
            lotto = new Lotto();
            lotto.generate();
            drawLottos.add(lotto);
        }
        return drawLottos;
    }

    public LottoResult calculation(WinLotto winLotto) {
        LottoResult calcResult = new LottoResult();
        for (Lotto lotto : lottos) {
            calcResult.counting(lotto.compare(winLotto));
        }
        calcResult.calculationYield(purchaseMoney);
        return calcResult;
    }

    public static Lottos combine(Lottos manualLottos, Lottos autoLottos) {
        List<Lotto> lottos = new ArrayList<>();
        lottos.addAll(manualLottos.getLottos());
        lottos.addAll(autoLottos.getLottos());
        return new Lottos(manualLottos.getPurchaseMoney().getMoney() + autoLottos.getPurchaseMoney().getMoney(), lottos);
    }
}
