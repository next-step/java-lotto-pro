package lotto;

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
        return result.entrySet().stream()
                .filter(map -> lottoWin.getPrizeMoneyByMatch().get(map.getKey()) != null)
                .map(e -> new LottoResultItem(
                        e.getKey(),
                        lottoWin.getPrizeMoneyByMatch().get(e.getKey()),
                        e.getValue()))
                .collect(Collectors.toList());
    }

    public int getCount(Match match) {
        return result.getOrDefault(match, 0);
    }
}
