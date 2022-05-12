package lotto.domain;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import lotto.enums.WinningRank;

public class WinningRecord {
    private static final Integer INIT_COUNT = 0;
    private final LinkedHashMap<WinningRank, Integer> winningRankCountMap;

    private WinningRecord(LinkedHashMap<WinningRank, Integer> winningRankCountMap) {
        this.winningRankCountMap = winningRankCountMap;
    }

    public static WinningRecord createEmpty() {
        LinkedHashMap<WinningRank, Integer> initWinningRankCountMap = new LinkedHashMap<>();
        WinningRank.winningValues().forEach(wr -> initWinningRankCountMap.put(wr, INIT_COUNT));
        return new WinningRecord(initWinningRankCountMap);
    }

    public void recording(WinningRank winningRank) {
        if(!validateRecordingWinningRank(winningRank)){
            return;
        }

        this.winningRankCountMap.put(winningRank, this.winningRankCountMap.get(winningRank) + 1);
    }

    private boolean validateRecordingWinningRank(WinningRank winningRank) {
        return WinningRank.isWinningRank(winningRank);
    }

    public Map<WinningRank, Integer> getRecord() {
        return this.winningRankCountMap;
    }

    public double getTotalPrizeMoney() {
        double totalPrizeMoney = 0;
        for (Entry<WinningRank, Integer> entry : this.winningRankCountMap.entrySet()) {
            totalPrizeMoney += entry.getKey().getPrizeMoney() * entry.getValue();
        }
        return totalPrizeMoney;
    }
}
