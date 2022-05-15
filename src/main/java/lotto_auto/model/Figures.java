package lotto_auto.model;

import java.util.*;

public class Figures {
    private Map<LottoRank, Integer> figures;
    private static final int DEFAULT_RANK_COUNT = 0;
    public static final String FIGURES_FORMAT = "%d개 일치 (%d원)- %d개\n";

    public Figures(Lottos lottos, Lotto winningsLotto) {
        init();
        for (Lotto lotto : lottos.getLottoList()) {
            LottoRank rank = lotto.matches(winningsLotto);
            int count = figures.getOrDefault(rank, DEFAULT_RANK_COUNT);
            figures.put(rank, count + 1);
        }

        figures.remove(LottoRank.NOTHING);
    }

    private void init() {
        figures = new EnumMap<>(LottoRank.class);

        for (LottoRank rank : LottoRank.values()) {
            figures.put(rank, DEFAULT_RANK_COUNT);
        }
    }

    public int getTotalWinning() {
        int winningMoney = 0;
        for (LottoRank rank : figures.keySet()) {
            winningMoney += rank.winnings() * figures.get(rank);
        }
        return winningMoney;
    }

    public String printFigures() {
        StringBuilder result = new StringBuilder();
        for (LottoRank rank : LottoRank.valuesTheLowestOrder()) {
            result.append(String.format(FIGURES_FORMAT, rank.matchedCount(), rank.winnings(), figures.get(rank)));
        }

        return result.toString();
    }
}
