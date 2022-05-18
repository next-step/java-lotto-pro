package Lotto;

public class Player {
    private PurchaseMoney purchaseMoney;
    private Lottos TotalLottos;

    public Lottos getTotalLottos() {
        return TotalLottos;
    }

    public Player(int money) {
        purchaseMoney = new PurchaseMoney(money);
    }

    public void drawManualAndRemainAuto(int manualCount) {
        purchaseMoney.manualValidation(manualCount);
        int manualMoney = purchaseMoney.getMoney() - (manualCount * PurchaseMoney.LOTTO_PURCHASE_UNIT);

        Lottos manualLottos = new Lottos(manualMoney);
        Lottos autoLottos = new Lottos(purchaseMoney.getMoney() - manualMoney);
        this.TotalLottos = Lottos.combine(manualLottos, autoLottos);
    }
}
