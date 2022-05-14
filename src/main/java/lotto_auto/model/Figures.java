package lotto_auto.model;

import java.util.*;

public class Figures {
    private Map<LottoRank, Integer> figures;
    private static final String printResultFormat = "%d개 일치 (%d원)- %d개\n";
    private Profit profit;

    public Figures(Lottos lottos, Lotto winningsLotto) {
        init();
        for (Lotto lotto : lottos) {
            LottoRank rank = LottoRank.matches(lotto, winningsLotto);
            int count = figures.getOrDefault(rank, 0);
            figures.put(rank, count + 1);
            profit.addProfit(rank.winnings());
        }

        figures.remove(LottoRank.NOTHING);
    }

    private void init() {
        figures = new EnumMap<>(LottoRank.class);
        profit = new Profit();
        for (LottoRank rank : LottoRank.values()) {
            figures.put(rank,0);
        }
    }

    public Profit getProfit(){
        return this.profit;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        for (LottoRank rank : LottoRank.valuesTheLowestOrder()) {
            result.append(String.format(printResultFormat, rank.matchedCount(), rank.winnings(), figures.get(rank)));
        }

        return result.toString();
    }
}
