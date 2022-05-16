package lotto.model;

public class PurchasePrice {
    private long purchasePrice;

    public PurchasePrice(long purchasePrice) {
        validatePurchasePrice(purchasePrice);
        this.purchasePrice = purchasePrice;
    }

    public int purchaseLottoCount() {
        return (int) (this.purchasePrice / PurchaseStatus.LOTTO_PRICE);
    }

    private void validatePurchasePrice(long purchasePrice) {
        if(purchasePrice < PurchaseStatus.LOTTO_PRICE){
            throw new IllegalArgumentException("금액이 적어 구입할 수 없습니다.");
        }

        if(purchasePrice % PurchaseStatus.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("잔돈이 발생합니다. 천 원단위로 나누어떨어지도록 금액을 입력해야 합니다.");
        }
    }

    public double averageRate(long sum) {
        return Math.floor(((double) sum/this.purchasePrice) * 100) / 100.0;
    }
}
