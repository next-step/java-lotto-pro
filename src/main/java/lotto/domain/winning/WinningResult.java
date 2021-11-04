package lotto.domain.winning;

import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.LottoRank;
import lotto.domain.lotto.LottoTicket;
import lotto.domain.lotto.LottoTickets;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class WinningResult {
    private static final int DEFAULT_MATCH_COUNT = 0;

    private final WinningNumbers winningNumbers;
    private final Map<LottoRank, Integer> winningResult;

    private Map<LottoRank, Integer> generate() {
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
        Set<LottoNumber> lottoNumbers = lottoTicket.getLottoNumbers();
        LottoRank key = LottoRank.findBy(winningNumbers.matchCount(lottoNumbers));
        winningResult.put(key, winningResult.get(key) + 1);
    }

    public int findMatchCount(LottoRank lottoRank) {
        return winningResult.get(lottoRank);
    }

    public int totalPrize() {
        return winningResult.keySet().stream()
                .mapToInt(rank -> rank.getPrizeMoney() * findMatchCount(rank))
                .sum();
    }

    public Set<LottoRank> getKeys() {
        Set<LottoRank> lottoRanks = winningResult.keySet();
        lottoRanks.remove(LottoRank.LOSE);
        return lottoRanks;
    }
}
