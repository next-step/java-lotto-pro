package lotto;

public class LottoPrice {
    public static final int LOTTO_PRICE = 1000;

    public LottoPrice(int price) {
        validatePrice(price);
    }

    public static void validatePrice(int price) {
        if (price % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("로또는 1000원 단위로만 구매할 수 있습니다.");
        }
    }
}
