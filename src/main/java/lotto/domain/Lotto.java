package lotto.domain;

import java.util.Collections;
import java.util.List;

import static lotto.domain.Money.GAME_PRICE;

public class Lotto {

    private final List<Rank> lottoRanks;

    public Lotto(List<Rank> lottoRanks) {
        this.lottoRanks = lottoRanks;
    }

    public int getMatchRankCount(Rank rank) {
        return Collections.frequency(lottoRanks, rank);
    }

    public double getLottoYield() {
        double purchaseAmount = lottoRanks.size() * GAME_PRICE;
        double sum = lottoRanks.stream().mapToInt(Rank::getPrizeMoney).sum() / purchaseAmount;
        double yield = getMatchAround(sum, 3);
        return yield;
    }

    private double getMatchAround(double value, int position) {
        double ndb = Math.pow(10.0, position);

        return (Math.round(value * ndb) / ndb);
    }
}
