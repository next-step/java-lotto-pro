package lotto.domain.common;

public class ManualLottoQuantity {

    private static final String MANUAL_LOTTO_QUANTITY_ERROR = "[ERROR] 수동 로또 매수는 음수가 될 수 없습니다.";

    private final int manualLottoQuantity;

    private ManualLottoQuantity(int manualLottoQuantity) {
        validate(manualLottoQuantity);
        this.manualLottoQuantity = manualLottoQuantity;
    }

    private void validate(int manualLottoQuantity) {
        if (manualLottoQuantity < 0) {
            throw new IllegalArgumentException(MANUAL_LOTTO_QUANTITY_ERROR);
        }
    }

    public static ManualLottoQuantity from(int manualLottoQuantity) {
        return new ManualLottoQuantity(manualLottoQuantity);
    }

    public int getManualLottoQuantity() {
        return manualLottoQuantity;
    }
}
