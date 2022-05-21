package lotto.domain;

import static lotto.message.InputMessage.INPUT_BONUS_NUMBER;
import static lotto.message.InputMessage.INPUT_LOTTO_TICKET;

public class LottoWinningTicket {
    private final LottoTicket lottoWinningTicket;
    private final LottoNumber bonusNumber;

    public LottoWinningTicket(LottoTicket lottoWinningTicket, LottoNumber bonusNumber) {
        validateNotNull(lottoWinningTicket, bonusNumber);
        this.lottoWinningTicket = lottoWinningTicket;
        this.bonusNumber = bonusNumber;
    }

    private void validateNotNull(LottoTicket lottoTicket, LottoNumber bonusNumber) {
        if (lottoTicket == null) {
            throw new IllegalArgumentException(INPUT_LOTTO_TICKET);
        }
        if (bonusNumber == null) {
            throw new IllegalArgumentException(INPUT_BONUS_NUMBER);
        }
    }
}
