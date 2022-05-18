package lotto.domain;

import lotto.dto.LottoResultItem;
import lotto.dto.LottoWin;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TicketCheckResult {

    private final Map<Rank, Integer> result;

    public TicketCheckResult(Map<Rank, Integer> result) {
        this.result = result;
    }

    public List<LottoResultItem> mapLottoResultItemList(LottoWin lottoWin) {
        return result.entrySet().stream()
                .map(rankCountEntry -> new LottoResultItem(
                        rankCountEntry.getKey(),
                        rankCountEntry.getValue()))
                .sorted(Comparator.comparing(LottoResultItem::getRank).reversed())
                .collect(Collectors.toList());
    }

    public int getCount(Rank rank) {
        return result.get(rank);
    }
}
