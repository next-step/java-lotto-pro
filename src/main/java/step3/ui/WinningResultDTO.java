package step3.ui;

import step3.domain.WinningLottoRank;

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
        for (WinningLottoRank rank : WinningLottoRank.values()) {
            sb.append(rank);
            sb.append("- ");
            sb.append(ranks.get(rank));
            sb.append("개\n");
        }
        return sb.toString();
    }
}
