package lotto;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import view.Printable;

public enum LottoResult implements Printable {
    THREE(3, new LottoMoney(5000)),
    FOUR(4, new LottoMoney(50000)),
    FIVE(5, new LottoMoney(1500000)),
    SIX(6, new LottoMoney(2000000000)),
    NONE(0, new LottoMoney(0));

    private final int correctCount;
    private final LottoMoney lottoMoney;

    private static final Map<Integer, LottoResult> countToLottoResultMap =
        Arrays.stream(values())
            .filter(lottoResult -> lottoResult != NONE)
            .collect(Collectors.toMap(lottoResult -> lottoResult.correctCount, Function.identity()));

    LottoResult(int correctCount, LottoMoney lottoMoney) {
        this.correctCount = correctCount;
        this.lottoMoney = lottoMoney;
    }

    public static LottoResult findResult(int correctCount) {
        return countToLottoResultMap.getOrDefault(correctCount, NONE);
    }

    public LottoMoney calculateMultipleMoney(int multiple) {
        return lottoMoney.calculateMultiple(multiple);
    }

    @Override
    public String makePrintableMessage() {
        return correctCount + "개 일치 (" + lottoMoney.makePrintableMessage() + ")";
    }
}
