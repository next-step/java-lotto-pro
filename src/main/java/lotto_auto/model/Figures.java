package lotto_auto.model;

import java.util.*;

public class Figures {
    private final Map<LottoRank, Integer> figures;
    public static final int DEFAULT_RANK_COUNT = 0;

    public Figures(Map<LottoRank, Integer> figures) {
        this.figures = figures;
        figures.remove(LottoRank.NOTHING);
    }

    public int getTotalWinning() {
        int winningMoney = 0;
        for (LottoRank rank : figures.keySet()) {
            winningMoney += rank.winnings() * figures.get(rank);
        }
        return winningMoney;
    }

    public int getCountBy(LottoRank rank) {
        return figures.getOrDefault(rank, DEFAULT_RANK_COUNT);
    }
}
