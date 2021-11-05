package lotto;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum LottoResult {
    THREE(3), FOUR(4), FIVE(5), SIX(6), NONE(0);

    private final int correctCount;

    private static final Map<Integer, LottoResult> countToLottoResultMap =
        Arrays.stream(values())
            .filter(lottoResult -> lottoResult != NONE)
            .collect(Collectors.toMap(lottoResult -> lottoResult.correctCount, Function.identity()));

    LottoResult(int correctCount) {
        this.correctCount = correctCount;
    }

    public static LottoResult findResult(int correctCount) {
        return countToLottoResultMap.getOrDefault(correctCount, NONE);
    }
}
