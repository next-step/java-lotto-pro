package lotto.domain;

import java.util.Arrays;
import java.util.stream.Collectors;
import lotto.Lotto;

public enum LottoRanking {
    MISS(0, 0),
    FOURTH_PRIZE(3, 5_000),
    THIRD_PRIZE(4, 50_000),
    SECOND_PRIZE(5, 1_500_000),
    FIRST_PRIZE(6, 2_000_000_000);

    public int matchingNumber;
    public int winAmount;

    LottoRanking(int matchingNumber, int winAmount) {
        this.matchingNumber = matchingNumber;
        this.winAmount = winAmount;
    }

    public static LottoRanking findLottoRaking(Lotto lotto, Lotto winningLotto) {
        int matchingNumber = winningLotto.getNumbers().getValues().stream()
            .filter(lotto.getNumbers().getValues()::contains)
            .collect(Collectors.toList()).size();

        return Arrays.stream(LottoRanking.values())
            .filter(lottoRanking -> lottoRanking.matchingNumber == matchingNumber)
            .findFirst().orElse(LottoRanking.MISS);
    }


}
