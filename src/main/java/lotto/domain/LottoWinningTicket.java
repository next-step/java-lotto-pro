package lotto.domain;

import static lotto.message.InputMessage.*;

public class LottoWinningTicket {
    private final LottoTicket lottoWinningTicket;
    private final LottoNumber bonusNumber;

    public LottoWinningTicket(LottoTicket lottoWinningTicket, LottoNumber bonusNumber) {
        validate(lottoWinningTicket, bonusNumber);
        this.lottoWinningTicket = lottoWinningTicket;
        this.bonusNumber = bonusNumber;
    }

    private void validate(LottoTicket lottoWinningTicket, LottoNumber bonusNumber) {
        validateNotNull(lottoWinningTicket, bonusNumber);
        validateUnique(lottoWinningTicket, bonusNumber);
    }

    private void validateUnique(LottoTicket lottoWinningTicket, LottoNumber bonusNumber) {
        if (lottoWinningTicket.contains(bonusNumber)) {
            throw new IllegalArgumentException(INVALID_LOTTO_UNIQUE);
        }
    }

    private void validateNotNull(LottoTicket lottoTicket, LottoNumber bonusNumber) {
        if (lottoTicket == null) {
            throw new IllegalArgumentException(INVALID_LOTTO_TICKET);
        }
        if (bonusNumber == null) {
            throw new IllegalArgumentException(INVALID_BONUS_NUMBER);
        }
    }

    public LottoRanks analyzeResult(LottoTickets tickets) {
        return tickets.lottoResult(lottoWinningTicket, bonusNumber);
    }
}

