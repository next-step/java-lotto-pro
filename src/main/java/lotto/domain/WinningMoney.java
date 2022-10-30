package lotto.domain;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class WinningMoney {
    private final List<Rank> ranks;

    public WinningMoney(List<Rank> ranks) {
        this.ranks = ranks;
    }

    public int count(Rank rankToCount) {
        return (int) this.ranks.stream()
                .filter(rank -> rank.equals(rankToCount))
                .count();
    }

    public double calcYield(Money money) {
        Optional<Integer> totalWinningAmountOptional = this.ranks.stream()
                .map(Rank::getWinningAmount)
                .reduce(Integer::sum);
        
        return totalWinningAmountOptional.map(money::divide).orElse(0D);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningMoney that = (WinningMoney) o;
        List<Rank> sortedRank = ranks.stream().sorted().collect(Collectors.toList());
        List<Rank> sortedThatRank = that.ranks.stream().sorted().collect(Collectors.toList());
        return sortedRank.equals(sortedThatRank);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ranks);
    }
}
