package Lotto;

public class PurchaseCount {
    private int count;

    public int getCount() {
        return count;
    }

    public PurchaseCount(PurchaseMoney money) {
        this.count = money.getMoney() / 1000;
        toString();
    }

    @Override
    public String toString() {
        return count + "개를 구매했습니다";
    }
}
