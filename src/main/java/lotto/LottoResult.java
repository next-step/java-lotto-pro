package lotto;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum LottoResult {
    THREE(3, new LottoPrize(5000)),
    FOUR(4, new LottoPrize(50000)),
    FIVE(5, new LottoPrize(1500000)),
    SIX(6, new LottoPrize(2000000000)),
    NONE(0, new LottoPrize(0));

    private final int correctCount;
    private final LottoPrize lottoPrize;

    private static final Map<Integer, LottoResult> countToLottoResultMap =
        Arrays.stream(values())
            .filter(lottoResult -> lottoResult != NONE)
            .collect(Collectors.toMap(lottoResult -> lottoResult.correctCount, Function.identity()));

    LottoResult(int correctCount, LottoPrize lottoPrize) {
        this.correctCount = correctCount;
        this.lottoPrize = lottoPrize;
    }

    public static LottoResult findResult(int correctCount) {
        return countToLottoResultMap.getOrDefault(correctCount, NONE);
    }

    public LottoPrize calculateMultiplePrize(int multiple) {
        return lottoPrize.calculateMultiple(multiple);
    }
}
