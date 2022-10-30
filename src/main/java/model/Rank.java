package model;

import java.util.*;

import static model.LottoRankType.*;

public class Rank {
    private static final List<LottoRankType> rank = Arrays.asList(RANK_ONE, RANK_TWO, RANK_THREE, RANK_FOUR);
    private final Map<LottoRankType, Integer> countRank;

    public Rank() {
        this.countRank = new TreeMap<>();
        for (LottoRankType lottoRankType : rank) {
            countRank.put(lottoRankType, 0);
        }
    }

    public void stats(List<LottoNumber> buyLotto, List<Integer> winNumber) {
        for (LottoNumber lotto : buyLotto) {
            int winNumberCount = lotto.getWinNumberCount(winNumber);
            LottoRankType lottoRankType = LottoRankType.convertRank(winNumberCount);
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
            countRank.put(rankType, countRank.get(rankType) + 1);
        }
    }

    public Map<LottoRankType, Integer> getCountRank() {
        return countRank;
    }
}
