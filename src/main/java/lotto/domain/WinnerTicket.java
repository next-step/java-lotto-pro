package lotto.domain;

import java.util.Objects;
import java.util.stream.Collectors;

import lotto.exception.LottoErrorCode;
import lotto.exception.LottoException;

public class WinnerTicket {
    private final LottoTicket lottoTicket;
    private final BonusNumber bonusNumber;

    public WinnerTicket(LottoTicket lottoTicket, BonusNumber bonusNumber) {
        validate(lottoTicket, bonusNumber);
        this.lottoTicket = lottoTicket;
        this.bonusNumber = bonusNumber;
    }

    private void validate(LottoTicket lottoTicket, BonusNumber bonusNumber) {
        if (lottoTicket.getLottoNumbers().stream().anyMatch(bonusNumber::isBonus)) {
            throw new LottoException(LottoErrorCode.INVALID_BONUS_NUMBER);
        }
    }

    public LottoResults calculateResult(LottoTickets lottoTickets) {
        return new LottoResults(lottoTickets.getLottoTicketList().stream()
            .map(lottoTicket -> lottoTicket.calculateResult(this.lottoTicket, containsBonus(lottoTicket)))
            .collect(Collectors.toList()));
    }

    private boolean containsBonus(LottoTicket lottoTicket) {
        return lottoTicket.getLottoNumbers().stream().anyMatch(bonusNumber::isBonus);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof WinnerTicket)) {
            return false;
        }
        WinnerTicket that = (WinnerTicket)o;
        return Objects.equals(lottoTicket, that.lottoTicket) &&
            Objects.equals(bonusNumber, that.bonusNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoTicket, bonusNumber);
    }
}
