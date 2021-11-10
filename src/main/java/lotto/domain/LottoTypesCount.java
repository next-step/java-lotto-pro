package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoTypesCount {
    private final Map<LottoType, Integer> lottoTypesCount;

    public LottoTypesCount(int manualCount, int autoCount) {
        this.lottoTypesCount = createLottoTypesCount(manualCount, autoCount);
    }

    private Map<LottoType, Integer> createLottoTypesCount(int manualCount, int autoCount) {
        Map<LottoType, Integer> lottoTypesCount = new HashMap<>();
        lottoTypesCount.put(LottoType.MANUAL, manualCount);
        lottoTypesCount.put(LottoType.AUTO, autoCount);
        return lottoTypesCount;
    }

    public int getCountOfType(LottoType lottoType) {
        return lottoTypesCount.get(lottoType);
    }
}
