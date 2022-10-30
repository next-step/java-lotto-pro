package lotto.domain;

import lotto.domain.enums.Rank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private static final int DEFAULT_VALUE = 0;
    private static final int INCREASE_VALUE = 1;

    private final Map<Rank, Integer> lottoResultCounts = new HashMap<>();
    private final LottoTicket winningTicket;

    public LottoResult(LottoTicket ticket) {
        initialize();
        this.winningTicket = ticket;
    }

    private void initialize() {
        for (Rank rank : Rank.values()) {
            lottoResultCounts.put(rank, DEFAULT_VALUE);
        }
    }

    public Map<Rank, Integer> statistics(List<LottoTicket> tickets) {
        tickets.forEach(this::addLottoResultCounts);
        return lottoResultCounts;
    }

    private void addLottoResultCounts(LottoTicket ticket) {
        int matchCount = countOfMatch(ticket);
        if (Rank.isBiggerThanMinimum(matchCount)) {
            lottoResultCounts.merge(Rank.get(matchCount), INCREASE_VALUE, Integer::sum);
        }
    }



    private int countOfMatch(LottoTicket ticket) {
        return winningTicket.containCount(ticket);
    }

    public double returnRate(Money totalReturnMoney, Money money) {
        return totalReturnMoney.divide(money);
    }
}
