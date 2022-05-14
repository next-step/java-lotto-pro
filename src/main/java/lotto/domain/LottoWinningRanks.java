package lotto.domain;

import lotto.enums.Rank;

import java.util.ArrayList;
import java.util.List;

public class LottoWinningRanks {
    private final List<Rank> winningRanks = new ArrayList<>();

    public void addWinningRank(Rank rank) {
        if (Rank.isWinning(rank)) {
            this.winningRanks.add(rank);
        }
    }

    public int size() {
        return this.winningRanks.size();
    }

    public int rankCount(Rank findRank) {
        return (int) this.winningRanks.stream()
                .filter(rank -> rank.name().equals(findRank.name())).count();
    }
}
