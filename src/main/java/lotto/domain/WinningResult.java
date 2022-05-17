package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningResult {
    private final double MATH_ROUND_DIGIT = 100d;
    private static final String MESSAGE_MATCHED_COUNT = "%d개 일치 (%d원)- %d개\n";
    private static final String TEXT_PROFIT = "이득이";
    private static final String TEXT_PRINCIPAL = "본전이";
    private static final String TEXT_LOSS = "손해";

    private List<LottoRank> winningRanks = new ArrayList<>();

    public int size() {
        return this.winningRanks.size();
    }

    public void addWinningRank(LottoRank lottoRank) {
        if (LottoRank.isWinning(lottoRank)) {
            this.winningRanks.add(lottoRank);
        }
    }

    public int countRank(LottoRank findRank) {
        return (int) this.winningRanks.stream()
                .filter(rank -> rank.name().equals(findRank.name()))
                .count();
    }

    public double profitRate(Money purchaseMoney) {
        double totalPrizeMoneyDouble = totalPrizeMoney();
        double purchaseMoneyDouble = purchaseMoney.getMoney();
        double profitRate = totalPrizeMoneyDouble / purchaseMoneyDouble;
        return Math.round(profitRate * MATH_ROUND_DIGIT) / MATH_ROUND_DIGIT;
    }

    public int totalPrizeMoney() {
        int totalPrizeMoney = this.winningRanks.stream()
                .map(LottoRank::getPrizeMoney)
                .reduce(0, Integer::sum);
        return totalPrizeMoney;
    }

    public String profitResultDescription(Money purchaseMoney) {
        int totalPrizeMoney = totalPrizeMoney();
        if (purchaseMoney.getMoney() < totalPrizeMoney) {
            return TEXT_PROFIT;
        }
        if (purchaseMoney.getMoney() > totalPrizeMoney) {
            return TEXT_LOSS;
        }
        return TEXT_PRINCIPAL;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (LottoRank rank : LottoRank.winningRanks()) {
            sb.append(String.format(MESSAGE_MATCHED_COUNT, rank.getMatchCount(), rank.getPrizeMoney(), countRank(rank)));
        }
        return sb.toString();
    }
}
