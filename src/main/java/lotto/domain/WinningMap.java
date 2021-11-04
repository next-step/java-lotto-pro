package lotto.domain;

import java.util.Map;
import java.util.stream.Collectors;

public class WinningMap {
    private final Map<Rank, Integer> winningMap;

    private WinningMap(final Map<Rank, Integer> winningMap) {
        this.winningMap = winningMap;
    }

    public static WinningMap winningOf(final LottoTicket lottoTicket, final Winning winning) {
        LottoNumbers winningNumbers = winning.getWinningNumbers();

        return new WinningMap(lottoTicket.getTicket()
                .stream()
                .filter(lottoNumbers -> Rank.valueOf(lottoNumbers
                        .match(winningNumbers))
                        .isNotMiss())
                .collect(Collectors.toMap(
                        lottoNumbers -> Rank.valueOf(lottoNumbers.match(winningNumbers)),
                        lottoNumbers -> 1,
                        (oldValue, newValue) -> oldValue + newValue)
                ));
    }

    public Map<Rank, Integer> getWinningMap() {
        return winningMap;
    }

    public int revenue(BoughtLotto boughtLotto) {
        return winningMap.keySet()
                .stream()
                .mapToInt(rank -> rank.calculateRevenue(winningMap.get(rank)))
                .sum() / boughtLotto.getBoughtMoney();
    }
}
