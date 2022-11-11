package lotto.domain;

public class LottoMoney {

    public static final int LOTTO_MINIMUM_PRICE = 1000;
    public static final String MANUAL_COUNT_EXCEPTION_MESSAGE = "수동 구매 횟수가 로또 구매 횟수보다 클 수 없습니다.";
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
        int purchaseCount = this.number / LOTTO_MINIMUM_PRICE;
        if (purchaseCount < manualLottoCount) {
            throw new IllegalArgumentException(MANUAL_COUNT_EXCEPTION_MESSAGE);
        }
        return purchaseCount - manualLottoCount;
    }

}
