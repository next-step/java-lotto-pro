package study.step3;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Set;
import study.step3.enumtype.LottoWinningType;

public class LottoResultMap {
    private static final int EMPTY_SIZE = 0;
    private final EnumMap<LottoWinningType, List<Lotto>> resultMap;

    public LottoResultMap() {
        this.resultMap = new EnumMap<>(LottoWinningType.class);
    }

    public void append(LottoWinningType lottoWinningType, Lotto lotto) {
        resultMap.computeIfAbsent(lottoWinningType, key -> (new ArrayList<>()));
        resultMap.get(lottoWinningType).add(lotto);
    }

    public int matchCount(LottoWinningType lottoWinningType) {
        if (!resultMap.containsKey(lottoWinningType)) {
            return EMPTY_SIZE;
        }
        return resultMap.get(lottoWinningType).size();
    }

    public Set<LottoWinningType> keySet() {
        return resultMap.keySet();
    }

    public int allItemSize() {
        return resultMap.keySet().stream()
                .mapToInt(lottoWinningType -> resultMap.get(lottoWinningType).size())
                .sum();
    }

    public float calcLottoYield() {
        int totalWinnings = calcTotalWinnings();
        if (totalWinnings == 0) {
            return 0f;
        }

        int cost = LottoMoney.countAmount(allItemSize());
        return (float) totalWinnings / cost * 100f;
    }

    private int calcTotalWinnings() {
        return this.resultMap.keySet().stream()
                .mapToInt(
                        lottoWinningType -> matchCount(lottoWinningType) * lottoWinningType.getWinnings()
                ).sum();
    }
}
