package lotto.service;

import lotto.domain.*;
import lotto.exception.NotEnoughMoneyException;

public class LottoService {

    public static final int LOTTO_TICKET_PRICE = 1000;

    public LottoService() {
    }

    public LottoTickets buyAutoLottoTickets(TicketAmount countsOfAutoTickets) {
        return LottoTickets.generateRandomLottoTickets(countsOfAutoTickets);
    }

    public GameResult getGameResult(LottoTickets lottoTickets, WinningLottoNumbers winningLottoNumbers) {
        return lottoTickets.getGameResult(winningLottoNumbers);
    }

    public TicketAmount getCountsOfAutoTickets(Money inputMoney, TicketAmount countsOfManualTickets) {
        int countsOfAutoTickets = inputMoney.getLottoAmount(LOTTO_TICKET_PRICE) - countsOfManualTickets.getTicketAmount();
        if (countsOfAutoTickets < 0) {
            throw new NotEnoughMoneyException();
        }
        return new TicketAmount(countsOfAutoTickets);
    }
}
