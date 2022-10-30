package study.lotto.domain;

import study.util.NumberUtil;

import java.util.Arrays;
import java.util.Optional;

public enum LottoStatus {
    NONE(0, 0),
    FOURTH_PLACE(3, 5000),
    THIRD_PLACE(4, 50000),
    SECOND_PLACE(5, 1500000),
    FIRST_PLACE(6, 2000000000);

    private int result;
    private int amount;

    LottoStatus(int result, int amount) {
        this.result = result;
        this.amount = amount;
    }

    public static LottoStatus getLottoStatus(int result) {
        return matchLottoStatus(result)
                .orElseGet(() -> LottoStatus.NONE);
    }

    private static Optional<LottoStatus> matchLottoStatus(int result) {
        return Arrays.stream(values())
                .filter((status) -> status.result == result)
                .findFirst();
    }

    public long accumlateByLottoStatus(long currentAmount) {
        return currentAmount + this.amount;
    }

    public long countByLottoStatus(long totalAmountOfLottoStatus) {
        if(totalAmountOfLottoStatus <= NumberUtil.INIT_ZERO_LONG) {
            return NumberUtil.INIT_ZERO_LONG;
        }
        return NumberUtil.divideAndCeil(totalAmountOfLottoStatus, this.amount);
    }

}
