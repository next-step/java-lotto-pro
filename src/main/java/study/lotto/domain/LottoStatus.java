package study.lotto.domain;

import study.util.NumberUtil;

import java.util.Arrays;
import java.util.Optional;

public enum LottoStatus {
    NONE(0, 0),
    FIFTH_PLACE(3, 5_000),
    FOURTH_PLACE(4, 50_000),
    THIRD_PLACE(5, 1_500_000),
    SECOND_PLACE(5, 30_000_000),
    FIRST_PLACE(6, 2_000_000_000);

    private static final int SECOND_PLACE_OR_THIRD_PLACE_RESULT = 5;

    private int result;
    private int amount;

    LottoStatus(int result, int amount) {
        this.result = result;
        this.amount = amount;
    }

    public static LottoStatus getLottoStatus(int result, boolean matchBonusBall) {
        if(matchSecondPlace(result, matchBonusBall)) {
            return LottoStatus.SECOND_PLACE;
        }

        return matchLottoStatus(result)
                .orElseGet(() -> LottoStatus.NONE);
    }

    private static boolean matchSecondPlace(int result, boolean matchBonusBall) {
        return result == SECOND_PLACE_OR_THIRD_PLACE_RESULT && matchBonusBall;
    }

    private static Optional<LottoStatus> matchLottoStatus(int result) {
        return Arrays.stream(values())
                .filter((status) -> {
                    return status != LottoStatus.SECOND_PLACE && status.result == result;
                })
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
