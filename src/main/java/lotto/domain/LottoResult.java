package lotto.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private static final int DEFAULT_VALUE = 0;
    private static final int INCREASE_VALUE = 1;

    private final Map<Rank, Integer> lottoResultCounts = new LinkedHashMap<>();
    private final LottoTicket winningTicket;

    public LottoResult(LottoTicket ticket) {
        initialize();
        this.winningTicket = ticket;
    }

    private void initialize() {
        for (Rank rank : Rank.reverseValues()) {
            lottoResultCounts.put(rank, DEFAULT_VALUE);
        }
    }

    public Map<Rank, Integer> statistics(List<LottoTicket> tickets, LottoNumber bonusNumber) {
        tickets.forEach(ticket -> addLottoResultCounts(ticket, bonusNumber));
        lottoResultCounts.entrySet().removeIf(entry -> entry.getKey() == Rank.MISS);
        return lottoResultCounts;
    }

    private void addLottoResultCounts(LottoTicket ticket, LottoNumber bonusNumber) {
        int matchCount = winningTicket.containCount(ticket);
        lottoResultCounts.merge(Rank.get(matchCount, ticket.contain(bonusNumber)), INCREASE_VALUE, Integer::sum);
    }

    public double returnRate(Money money) {
        return calculateTotalPrice().divide(money);
    }

    private Money calculateTotalPrice() {
        Money totalMoney = new Money(0L);
        for (Rank rank : lottoResultCounts.keySet()) {
            int count = lottoResultCounts.get(rank);
            totalMoney = totalMoney.sum(rank.getMoney().multiply(count));
        }

        return totalMoney;
    }
}
