package lotto.ui;

import lotto.domain.WinningLottoRank;

import java.util.Map;

public class WinningResultDTO {
    private final Map<WinningLottoRank, Integer> ranks;
    private final double yield;

    public WinningResultDTO(Map<WinningLottoRank, Integer> ranks, double yield) {
        this.ranks = ranks;
        this.yield = yield;
    }

    public double yield() {
        return yield;
    }

    public String ranks() {
        StringBuffer sb = new StringBuffer();
        sb.append("당첨 통계\n");
        sb.append("---------\n");
        WinningLottoRank[] ranks = WinningLottoRank.values();
        for (int i = ranks.length - 2; i >= 0; i--) {
            printRank(sb, ranks[i]);
        }
        return sb.toString();
    }

    private void printRank(StringBuffer sb, WinningLottoRank rank) {
        sb.append(rank.getMatchCount());
        sb.append("개 일치");
        if (rank == WinningLottoRank.SECOND) {
            sb.append(", 보너스 볼 일치");
        }
        sb.append(" (");
        sb.append(rank.getReward());
        sb.append("원)");

        sb.append("- ");
        sb.append(this.ranks.get(rank));
        sb.append("개\n");
    }
}
