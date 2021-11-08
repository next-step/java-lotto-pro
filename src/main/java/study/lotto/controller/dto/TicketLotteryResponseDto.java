package study.lotto.controller.dto;

import study.lotto.model.LottoNumber;
import study.lotto.model.TicketLottery;
import study.lotto.model.TicketLotteryType;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class TicketLotteryResponseDto {
    private final Set<Integer> lottoNumbers = new HashSet<>();
    private final TicketLotteryType type;

    public TicketLotteryResponseDto(final TicketLottery ticketLottery) {
        this.type = ticketLottery.getType();
        final Set<LottoNumber> lottoNumbers = ticketLottery.getLottoNumbers();
        for (final LottoNumber lottoNumber : lottoNumbers) {
            this.lottoNumbers.add(lottoNumber.getValue());
        }
    }

    public Set<Integer> getLottoNumbers() {
        return Collections.unmodifiableSet(lottoNumbers);
    }

    public TicketLotteryType getType() {
        return type;
    }
}
