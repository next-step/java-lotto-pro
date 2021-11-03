package lotto.domain.statistics;

import lotto.domain.lotto.LottoTicket;
import lotto.domain.lotto.LottoTickets;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class WinningResult {
    private static final int DEFAULT_MATCH_COUNT = 0;

    private final WinningNumbers winningNumbers;
    private final Map<LottoRank, Integer> winningResult;

    private static Map<LottoRank, Integer> generate() {
        Map<LottoRank, Integer> map = new LinkedHashMap<>();
        Arrays.stream(LottoRank.values())
                .forEach(rank -> map.put(rank, DEFAULT_MATCH_COUNT));
        return map;
    }

    public WinningResult(WinningNumbers winningNumbers) {
        this.winningNumbers = winningNumbers;
        this.winningResult = generate();
    }

    public void aggregate(LottoTickets lottoTickets) {
        lottoTickets.getLottoTickets().forEach(this::addWinningCount);
    }

    private void addWinningCount(LottoTicket lottoTicket) {
        LottoRank key = LottoRank.findBy(winningNumbers.matchCount(lottoTicket));
        winningResult.put(key, winningResult.get(key) + 1);
    }

    public int getMatchCount(LottoRank lottoRank) {
        return winningResult.get(lottoRank);
    }
}
