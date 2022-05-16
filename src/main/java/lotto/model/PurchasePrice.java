package lotto.model;

public class PurchasePrice {
    private long purchasePrice;

    public PurchasePrice(long purchasePrice) {
        validatePurchasePrice(purchasePrice);
        this.purchasePrice = purchasePrice;
    }

    public int purchaseLottoCount() {
        return (int) (this.purchasePrice / Lotto.LOTTO_PRICE);
    }

    private void validatePurchasePrice(long purchasePrice) {
        if(purchasePrice < Lotto.LOTTO_PRICE){
            throw new IllegalArgumentException("금액이 적어 구입할 수 없습니다.");
        }

        if(purchasePrice % Lotto.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("잔돈이 발생합니다. 천 원단위로 나누어떨어지도록 금액을 입력해야 합니다.");
        }
    }

    public double averageRate(long sum) {
        return Math.floor(((double) sum/this.purchasePrice) * 100) / 100.0;
    }

    public long excludePrice(long excludePrice) {
        return this.purchasePrice - excludePrice;
    }

    public void validatePurchasePrice(int purchaseCount) {
        long purchasePrice = (long) purchaseCount * Lotto.LOTTO_PRICE;
        if(0 > this.purchasePrice - purchasePrice){
            throw new IllegalArgumentException("구매할 수 있는 수동 로또의 개수를 초과하였습니다.");
        }
    }
}
