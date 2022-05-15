package lotto.domain;

import lotto.constants.DisplayMessage;
import lotto.enums.Rank;

import java.util.ArrayList;
import java.util.List;

public class LottoWinningRanks {
    private final double RETURN_RATE_CRITERIA = 1d;
    private final List<Rank> winningRanks = new ArrayList<>();

    private LottoWinningRanks() {}

    public static LottoWinningRanks create() {
        return new LottoWinningRanks();
    }

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
                .filter(rank -> rank.name().equals(findRank.name()))
                .count();
    }

    public double returnRate(Money purchaseMoney) {
        return purchaseMoney.returnRate(totalPrizeMoney());
    }

    public String resultDescription(Money purchaseMoney) {
        double returnRate = returnRate(purchaseMoney);
        if (returnRate > RETURN_RATE_CRITERIA) {
            return DisplayMessage.GAIN_AND_POST_POSITION;
        }
        if (returnRate < RETURN_RATE_CRITERIA) {
            return DisplayMessage.LOSS;
        }
        return DisplayMessage.PRINCIPAL_AND_POST_POSITION;
    }

    private Money totalPrizeMoney() {
        int totalPrizeMoney = this.winningRanks.stream()
                .map(Rank::getMoney)
                .reduce(0, Integer::sum);
        return Money.from(totalPrizeMoney);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Rank rank : Rank.winningRanks()) {
            sb.append(String.format(DisplayMessage.WINNING_RANK_INFO,
                    rank.getMatchCount(), rank.getMoney(), rankCount(rank)));
        }
        return sb.toString();
    }
}
