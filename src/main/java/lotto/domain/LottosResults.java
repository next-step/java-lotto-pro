package lotto.domain;

import java.util.Map;
import lotto.enums.LottoRank;

public class LottosResults {

    private static final String ERROR_MESSAGE_RESULT_MAP_NULL_OR_EMPTY = "[ERROR] Lottos resultMap is null or empty.";

    private final Map<LottoRank, Integer> resultMap;

    public LottosResults(Map<LottoRank, Integer> resultMap) {
        validateResultMapIsNullOrEmpty(resultMap);

        this.resultMap = resultMap;
    }

    public Integer getRankCount(LottoRank rank) {
        if(resultMap.containsKey(rank)) {
            return resultMap.get(rank);
        }

        return 0;
    }

    public Integer calculateTotalMoney() {
        int totalMoney = 0;

        for (LottoRank key : resultMap.keySet()) {
            totalMoney += key.getWinningMoney() * resultMap.get(key);
        }

        return totalMoney;
    }

    private void validateResultMapIsNullOrEmpty(Map<LottoRank, Integer> resultMap) {
        if (resultMap == null || resultMap.isEmpty()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_RESULT_MAP_NULL_OR_EMPTY);
        }
    }

}
