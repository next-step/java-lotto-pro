package lotto.domain;

import java.util.Objects;

/**
 * packageName : lotto.domain
 * fileName : PurchasePrice
 * author : haedoang
 * date : 2021-11-05
 * description : 구입 금액 클래스
 */
public class PurchasePrice {
    public static final int LOTTO_PRICE = 1000;
    private final int purchaseQuantity;

    public PurchasePrice(int price) {
        if (price < LOTTO_PRICE) throw new IllegalArgumentException("로또를 구입할 금액이 부족합니다.");
        this.purchaseQuantity = this.calculateQuantity(price);
    }

    private int calculateQuantity(int price) {
        return price / LOTTO_PRICE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PurchasePrice that = (PurchasePrice) o;
        return purchaseQuantity == that.purchaseQuantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(purchaseQuantity);
    }
}
