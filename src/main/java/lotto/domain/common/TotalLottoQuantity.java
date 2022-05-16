package lotto.domain.common;

public class TotalLottoQuantity {

    private static final String TOTAL_LOTTO_QUANTITY_ERROR = "[ERROR] 전체 로또 매수는 음수가 될 수 없습니다.";

    private final int totalLottoQuantity;

    private TotalLottoQuantity(int totalLottoQuantity) {
        validate(totalLottoQuantity);
        this.totalLottoQuantity = totalLottoQuantity;
    }

    private void validate(int totalLottoQuantity) {
        if (totalLottoQuantity < 0) {
            throw new IllegalArgumentException(TOTAL_LOTTO_QUANTITY_ERROR);
        }
    }

    public static TotalLottoQuantity from(int totalLottoQuantity) {
        return new TotalLottoQuantity(totalLottoQuantity);
    }

    public int getTotalLottoQuantity() {
        return totalLottoQuantity;
    }
}
