package model;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static model.LottoRankType.*;

public class Rank {

    private final Map<LottoRankType, Integer> countRank;

    private final static int ADD_LOTTO_COUNT = 1;
    private final static int INIT_MAP_COUNT = 0;

    public Rank() {
        List<LottoRankType> rank = Arrays.asList(RANK_ONE, RANK_TWO, RANK_THREE, RANK_FOUR);
        this.countRank = new TreeMap<>();

        for (LottoRankType lottoRankType : rank) {
            countRank.put(lottoRankType, INIT_MAP_COUNT);
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
