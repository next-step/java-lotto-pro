package model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static model.LottoRankType.*;

public class Rank {
    private static final List<LottoRankType> rank = Arrays.asList(RANK_ONE, RANK_TWO, RANK_THREE, RANK_FOUR, RANK_FAIL);
    private final Map<LottoRankType, Integer> countRank;

    public Rank() {
        this.countRank = new HashMap<>();
        for (LottoRankType lottoRankType : rank) {
            countRank.put(lottoRankType, 0);
        }
    }

    public void stats(List<LottoNumber> buyLotto, List<Integer> winNumber) {
        for (LottoNumber lotto : buyLotto) {
            int winNumberCount = lotto.getWinNumberCount(winNumber);
            LottoRankType lottoRankType = LottoRankType.convertRank(winNumberCount);
            for (LottoRankType rankType : countRank.keySet()) {
                if (rankType == lottoRankType) {
                    countRank.put(lottoRankType, countRank.get(rankType) + 1);
                }
            }
        }
    }

    public Map<LottoRankType, Integer> getCountRank() {
        return countRank;
    }
}
