package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoRewardResult {

    private Map<LottoReward, Integer> lottoRewardMap = new HashMap<>();

    public LottoRewardResult(Map<LottoReward, Integer> lottoRewardMap) {
        this.lottoRewardMap = lottoRewardMap;
    }

    public Map<LottoReward, Integer> getLottoRewardMap() {
        return lottoRewardMap;
    }
}
