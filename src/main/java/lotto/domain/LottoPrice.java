package lotto.domain;

public class LottoPrice {
    public static final int LOTTO_PRICE = 1_000;

    private final int price;

    public LottoPrice(int price) {
        validatePrice(price);
        this.price = price;
    }

    public static void validatePrice(int price) {
        if (price % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("로또는 1000원 단위로만 구매할 수 있습니다.");
        }
    }

    public Integer getCount() {
        return price / LOTTO_PRICE;
    }

    public int getPrice() {
        return price;
    }
}
