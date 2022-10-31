package lotto.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private static final int DEFAULT_VALUE = 0;
    private static final int INCREASE_VALUE = 1;

    private final Map<Rank, Integer> lottoResultCounts = new LinkedHashMap<>();
    private final LottoTicket winningTicket;
    private LottoNumber bonusNumber;

    public LottoResult(LottoTicket ticket) {
        initialize();
        this.winningTicket = ticket;
    }

    private void initialize() {
        for (Rank rank : Rank.reverseValues()) {
            lottoResultCounts.put(rank, DEFAULT_VALUE);
        }
    }

    public void chooseBonusNumber(LottoNumber number) {
        bonusNumber = number;
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

    public double returnRate(Money money) {
        return calculateTotalPrice().divide(money);
    }

    private Money calculateTotalPrice() {
        Money totalMoney = new Money(0L);
        for (Rank rank : Rank.values()) {
            int count = lottoResultCounts.get(rank);
            totalMoney = totalMoney.sum(rank.getMoney().multiply(count));
        }

        return totalMoney;
    }
}
