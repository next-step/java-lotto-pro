package lotto.domain;

import lotto.common.Constants;
import lotto.ui.ResultView;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    public PurchasePrice(String strPrice) {
        if(!isNumber(strPrice)) throw new NumberFormatException("숫자만 입력 가능합니다.");
        int price = Integer.parseInt(strPrice);
        if (price < LOTTO_PRICE) throw new IllegalArgumentException("로또를 구입할 금액이 부족합니다.");
        this.purchaseQuantity = this.calculateQuantity(price);
    }

    private boolean isNumber(String strPrice) {
        try {
             Integer.parseInt(strPrice);
        } catch(NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public int calculateQuantity(int price) {
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

    @Override
    public String toString() {
        return String.valueOf(purchaseQuantity);
    }

    public void print() {
        ResultView.print(this.purchaseQuantity + Constants.MSG_OUTPUT_PURCHASE_RESULT_SUFFIX);
    }

    public Lottos buyLottery() {
        return new Lottos(IntStream.range(0, purchaseQuantity).mapToObj(i -> LottoMaker.createLotto()).collect(Collectors.toList()));
    }
}
