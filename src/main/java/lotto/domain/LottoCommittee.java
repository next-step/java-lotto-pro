package lotto.domain;

import lotto.domain.dto.StatisticDto;

import java.util.List;
import java.util.stream.Collectors;

public class LottoCommittee {
    private final LottoTicket winningTicket;

    public LottoCommittee(List<Integer> numbers) {
        this.winningTicket = convertTicket(numbers);
    }

    private LottoTicket convertTicket(List<Integer> numbers) {
        return LottoTicket.create(numbers.stream()
                .map(v -> LottoNumber.get(v))
                .collect(Collectors.toList())
        );
    }

    public StatisticDto statistics(List<LottoTicket> tickets) {
        StatisticDto dto = StatisticDto.create();
        for (LottoTicket ticket : tickets) {
            dto.add(countOfMatch(ticket));
        }

        return dto;
    }

    private int countOfMatch(LottoTicket ticket) {
        return winningTicket.containCount(ticket);
    }

    public double returnRate(Money totalReturnMoney, Money money) {
        return totalReturnMoney.divide(money);
    }
}
