package lotto.domain;

import lotto.dto.LottoResultItem;
import lotto.dto.LottoWin;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TicketCheckResult {

    private final Map<Match, Integer> result;

    public TicketCheckResult(Map<Match, Integer> result) {
        this.result = result;
    }

    public List<LottoResultItem> mapLottoResultItemList(LottoWin lottoWin) {
        MatchPrizes matchPrizes = lottoWin.getMatchPrizes();
        return result.entrySet().stream()
                .filter(matchCountEntry -> matchPrizes.has(matchCountEntry.getKey()))
                .map(matchCountEntry -> new LottoResultItem(
                        matchCountEntry.getKey(),
                        matchPrizes.prizeMoney(matchCountEntry.getKey()),
                        matchCountEntry.getValue()))
                .collect(Collectors.toList());
    }

    public int getCount(Match match) {
        return result.getOrDefault(match, 0);
    }
}
