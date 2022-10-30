package model;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static model.LottoRankType.*;

public class Rank {

    private final Map<LottoRankType, Integer> countRank;

    private final static int ADD_LOTTO_COUNT = 1;

    public Rank() {
        this.countRank = new TreeMap<>();

        List<LottoRankType> rank = Arrays.asList(RANK_ONE, RANK_TWO, RANK_THREE, RANK_FOUR);

        for (LottoRankType lottoRankType : rank) {
            countRank.put(lottoRankType, 0);
        }
    }

    public void stats(Lottos lottos, List<Integer> winNumber) {
        for (LottoNumber lotto : lottos.getLotto()) {
            int winNumberCount = lotto.getWinNumberCount(winNumber);

            LottoRankType lottoRankType = convertRank(winNumberCount);

            addCountRank(lottoRankType);
        }
    }

    private void addCountRank(LottoRankType convertLottoRankType) {
        for (LottoRankType rankType : countRank.keySet()) {
            countUpIfSameRankType(rankType, convertLottoRankType);
        }
    }

    private void countUpIfSameRankType(LottoRankType rankType, LottoRankType convertLottoRankType) {
        if (rankType.isSameRankType(convertLottoRankType)) {
            countRank.put(rankType, countRank.get(rankType) + ADD_LOTTO_COUNT);
        }
    }

    public Map<LottoRankType, Integer> getCountRank() {
        return countRank;
    }
}
