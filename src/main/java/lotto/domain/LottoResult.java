package lotto.domain;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum LottoResult {
    FIRST(6, new LottoMoney(2_000_000_000)),
    SECOND(5, new LottoMoney(30_000_000)),
    THIRD(5, new LottoMoney(1_500_000)),
    FOURTH(4, new LottoMoney(50_000)),
    FIFTH(3, new LottoMoney(5_000)),
    MISS(0, new LottoMoney(0));

    private final int correctCount;
    private final LottoMoney lottoMoney;

    private static final Map<Integer, LottoResult> countToLottoResultMap =
        Arrays.stream(values())
            .filter(lottoResult -> lottoResult != MISS && lottoResult != SECOND)
            .collect(Collectors.toMap(lottoResult -> lottoResult.correctCount, Function.identity()));

    LottoResult(int correctCount, LottoMoney lottoMoney) {
        this.correctCount = correctCount;
        this.lottoMoney = lottoMoney;
    }

    public static LottoResult findResult(int correctCount) {
        return countToLottoResultMap.getOrDefault(correctCount, MISS);
    }

    public static LottoResult findResult(int correctCount, boolean containsBonus) {
        LottoResult result = countToLottoResultMap.getOrDefault(correctCount, MISS);
        if (result == THIRD && containsBonus) {
            return SECOND;
        }

        return result;
    }

    public LottoMoney getLottoMoney() {
        return lottoMoney;
    }

    public int getCorrectCount() {
        return correctCount;
    }
}
