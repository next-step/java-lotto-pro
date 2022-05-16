package lotto.domain;

public class LottoPrice {
    public static final int LOTTO_PRICE = 1_000;

    private final int price;
    private final int manualCount;

    public LottoPrice(int price, Integer manualCount) {
        this.price = price;
        this.manualCount = manualCount;
        validate();
    }

    public void validate() {
        if (this.price % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("로또는 1000원 단위로만 구매할 수 있습니다.");
        }
        if ((getAutoCount() + manualCount) * LOTTO_PRICE > price) {
            throw new IllegalArgumentException("입력받은 구입금액으로는 수동로또를 구매할 금액이 부족합니다.");
        }
    }

    public Integer getAutoCount() {
        return Math.max(price - manualCount * LOTTO_PRICE, 0) / LOTTO_PRICE;
    }

    public Integer getManualCount() {
        return manualCount;
    }

    public int getPrice() {
        return price;
    }
}
