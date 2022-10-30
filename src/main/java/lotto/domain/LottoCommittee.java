package lotto.domain;

import lotto.domain.dto.StatisticDto;

import java.util.List;

public class LottoCommittee {
    private final LottoTicket winningTicket;

    public LottoCommittee(LottoTicket ticket) {
        this.winningTicket = ticket;
    }

    public StatisticDto statistics(List<LottoTicket> tickets) {
        StatisticDto dto = StatisticDto.create();
        tickets.forEach(ticket -> dto.add(countOfMatch(ticket)));

        return dto;
    }

    private int countOfMatch(LottoTicket ticket) {
        return winningTicket.containCount(ticket);
    }

    public double returnRate(Money totalReturnMoney, Money money) {
        return totalReturnMoney.divide(money);
    }
}
