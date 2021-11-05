package study.lotto.controller.dto;

import study.lotto.model.LottoNumber;
import study.lotto.model.TicketLottery;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class TicketLotteryResponseDto {
    private final Set<Integer> lottoNumbers = new HashSet<>();

    public TicketLotteryResponseDto(final TicketLottery ticketLottery) {
        final Set<LottoNumber> lottoNumbers = ticketLottery.getLottoNumbers();
        for (final LottoNumber lottoNumber : lottoNumbers) {
            this.lottoNumbers.add(lottoNumber.getValue());
        }
    }

    public Set<Integer> getLottoNumbers() {
        return Collections.unmodifiableSet(lottoNumbers);
    }

    public Set<LottoNumber> toEntity() {
        final Set<LottoNumber> lottoNumbers = new HashSet<>();
        for (Integer lottoNumber : this.lottoNumbers) {
            lottoNumbers.add(LottoNumber.valueOf(lottoNumber));
        }

        return lottoNumbers;
    }
}
