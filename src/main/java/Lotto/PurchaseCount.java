package Lotto;

public class PurchaseCount {
    private int count = 0;

    public int getCount() {
        return count;
    }

    public PurchaseCount() {
    }

    public PurchaseCount(PurchaseMoney money) {
        this.count = money.getMoney() / 1000;
    }

    @Override
    public String toString() {
        return count + "개를 구매했습니다";
    }
}
