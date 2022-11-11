package lotto.domain;

public class LottoMoney {

    public static final int LOTTO_MINIMUM_PRICE = 1000;
    private final int number;

    public LottoMoney(int number) {
        this.number = number;
        validateMinimumPrice(number);
    }

    private void validateMinimumPrice(int number) {
        if (number < LOTTO_MINIMUM_PRICE) {
            throw new IllegalArgumentException(LOTTO_MINIMUM_PRICE + "원이상부터 로또 번호 생성 가능합니다.");
        }
    }

    public int purchaseCount(int manualLottoCount) {
        return number / LOTTO_MINIMUM_PRICE - manualLottoCount;
    }

}
