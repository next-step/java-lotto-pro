package Lotto;

public class PurchaseCount {
    private int count;

    public int getCount() {
        return count;
    }

    public PurchaseCount(PurchaseMoney money) {
        this.count = money.getMoney() / 1000;
    }
}
