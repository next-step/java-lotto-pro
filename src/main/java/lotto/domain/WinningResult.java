package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningResult {
    private static final String MESSAGE_MATCHED_COUNT = "%d개 일치 (%d원)- %d개\n";

    private List<LottoRank> winningRanks = new ArrayList<>();

    public int size() {
        return this.winningRanks.size();
    }

    public void addWinningRank(LottoRank lottoRank) {
        if(LottoRank.isWinning(lottoRank))
        this.winningRanks.add(lottoRank);
    }

    public int countRank(LottoRank findRank) {
        return (int) this.winningRanks.stream()
                .filter(rank -> rank.name().equals(findRank.name()))
                .count();
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
