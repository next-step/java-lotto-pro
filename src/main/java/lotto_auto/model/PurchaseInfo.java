package lotto_auto.model;

public class PurchaseInfo {
    Money money;
    LottoCount manualLottoCount;
    public static final String NOT_ENOUGH_MONEY = "[ERROR] 로또 수를 구매하기 위한 금액이 불충분 합니다.";

    public PurchaseInfo(Money money, LottoCount manualLottoCount) {
        this.money = money;
        this.manualLottoCount = manualLottoCount;
        checkManualLottoCount();
    }

    private void checkManualLottoCount() {
        if (money.canBuyLottoCount() - manualLottoCount.getCount() < 0) {
            throw new IllegalArgumentException(NOT_ENOUGH_MONEY);
        }
    }

    public int getAutoLottoCount() {
        return (money.getMoney() / Money.MIN_SIZE) - manualLottoCount.getCount();
    }

    public int getManualLottoCount() {
        return manualLottoCount.getCount();
    }
}
