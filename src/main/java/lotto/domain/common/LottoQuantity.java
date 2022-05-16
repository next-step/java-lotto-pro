package lotto.domain.common;

public class LottoQuantity {

    private static final String MANUAL_QUANTITY_BIGGER_ERROR = "[ERROR] 수동 로또 매수는 전체 로또 매수보다 클 수 없습니다..";

    private TotalLottoQuantity totalLottoQuantity;
    private ManualLottoQuantity manualLottoQuantity;

    private LottoQuantity(TotalLottoQuantity totalLottoQuantity, ManualLottoQuantity manualLottoQuantity) {
        validate(totalLottoQuantity, manualLottoQuantity);
        this.totalLottoQuantity = totalLottoQuantity;
        this.manualLottoQuantity = manualLottoQuantity;
    }

    public static LottoQuantity of(TotalLottoQuantity totalLottoQuantity, ManualLottoQuantity manualLottoQuantity) {
        return new LottoQuantity(totalLottoQuantity, manualLottoQuantity);
    }

    private void validate(TotalLottoQuantity totalLottoQuantity, ManualLottoQuantity manualLottoQuantity) {
        if (manualLottoQuantity.getManualLottoQuantity() > totalLottoQuantity.getTotalLottoQuantity()) {
            throw new IllegalArgumentException(MANUAL_QUANTITY_BIGGER_ERROR);
        }
    }

    public int getAutoLottoQuantity() {
        return totalLottoQuantity.getTotalLottoQuantity() - manualLottoQuantity.getManualLottoQuantity();
    }

    public ManualLottoQuantity manualLottoQuantity() {
        return manualLottoQuantity;
    }

    public TotalLottoQuantity totalLottoQuantity() {
        return totalLottoQuantity;
    }
}
