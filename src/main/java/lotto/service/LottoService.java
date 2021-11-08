package lotto.service;

import lotto.domain.GameResult;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import lotto.domain.Money;
import lotto.dto.LottoTicketsDTO;

public class LottoService {

    public static final int LOTTO_TICKET_PRICE = 1000;

    public LottoService() {
    }

    public LottoTickets buyLottoTickets(Money money) {
        int amount = getAmount(money);
        return LottoTickets.generateRandomLottoTickets(amount);
    }

    private int getAmount(Money money) {
        return money.get() / LOTTO_TICKET_PRICE;
    }

    public GameResult getGameResult(LottoTickets lottoTickets, LottoTicket winningNumber) {
        return lottoTickets.getGameResult(winningNumber);
    }
}
