package Lotto;

import Lotto.utils.InputView;
import Lotto.utils.ResultView;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private PurchaseMoney purchaseMoney = new PurchaseMoney();
    private PurchaseCount purchaseCount = new PurchaseCount();
    private List<Lotto> lottos = new ArrayList<Lotto>();

    public int getPurchaseMoney() {
        return purchaseMoney.getMoney();
    }

    public int getPurchaseCount() {
        return purchaseCount.getCount();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void addLottos(List<Lotto> lottos) {
        lottos.addAll(this.lottos);
    }

    public Lottos() {
    }

    public Lottos(int money) {
        if(money == 0)
            return;

        purchaseMoney = new PurchaseMoney(money);
        purchaseCount = new PurchaseCount(purchaseMoney);
    }

    public Lottos(int money, List<Lotto> lottos) {
        purchaseMoney = new PurchaseMoney(money);
        purchaseCount = new PurchaseCount(purchaseMoney);
        this.lottos = lottos;
    }

    public void draw() {
        if(purchaseCount.getCount() == 0)
            return;

        List<Lotto> drawLottos = new ArrayList<Lotto>();
        Lotto lotto;
        for(int i = 0; i < purchaseCount.getCount(); i++) {
            lotto = new Lotto();
            lotto.generate();
            drawLottos.add(lotto);
        }
        lottos = drawLottos;
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
        manualLottos.addLottos(lottos);
        autoLottos.addLottos(lottos);
        return new Lottos(manualLottos.getPurchaseMoney() + autoLottos.getPurchaseMoney(), lottos);
    }

    public void manualDraw(List<String> manualNumbersList) {
        for(int i = 0; i < manualNumbersList.size(); i++) {
            lottos.add(new Lotto(manualNumbersList.get(i)));
        }
    }
}
