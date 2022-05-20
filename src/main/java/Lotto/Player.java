package Lotto;

import Lotto.utils.InputView;

public class Player {
    private PurchaseMoney purchaseMoney;
    private int manualPurchaseCount = 0;
    private Lottos TotalLottos;

    public int getManualPurchaseCount() {
        return manualPurchaseCount;
    }

    public Lottos getTotalLottos() {
        return TotalLottos;
    }

    public Player(int money) {
        purchaseMoney = new PurchaseMoney(money);
    }

    public void drawManualAndRemainAuto(int manualCount) {
        purchaseMoney.manualValidation(manualCount);
        manualPurchaseCount = manualCount;

        int manualMoney = manualCount * PurchaseMoney.LOTTO_PURCHASE_UNIT;
        Lottos manualLottos = new Lottos(manualMoney);
        manualLottos.manualDraw(InputView.inputManualLottoNumber(manualLottos.getPurchaseCount()));
        Lottos autoLottos = new Lottos(purchaseMoney.getMoney() - manualMoney);
        autoLottos.draw();

        this.TotalLottos = Lottos.combine(manualLottos, autoLottos);
    }
}
