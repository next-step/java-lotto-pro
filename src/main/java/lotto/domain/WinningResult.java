package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningResult {
    private static final String TEXT_PROFIT = "이득이";
    private static final String TEXT_PRINCIPAL = "본전이";
    private static final String TEXT_LOSS = "손해";

    private final List<LottoRank> winningRanks = new ArrayList<>();

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
        return purchaseMoney.profitRate(totalPrizeMoney());
    }

    public int totalPrizeMoney() {
        int totalPrizeMoney = this.winningRanks.stream()
                .map(LottoRank::getPrizeMoney)
                .reduce(0, Integer::sum);
        return totalPrizeMoney;
    }

    public String profitResultDescription(Money purchaseMoney) {
        int totalPrizeMoney = totalPrizeMoney();
        if (purchaseMoney.isLessMoney(totalPrizeMoney)) {
            return TEXT_PROFIT;
        }
        if (purchaseMoney.isMoreMoney(totalPrizeMoney)) {
            return TEXT_LOSS;
        }
        return TEXT_PRINCIPAL;
    }
}
