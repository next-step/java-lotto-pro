package lotto.service;

import lotto.domain.GameResult;
import lotto.domain.LottoTickets;
import lotto.domain.Money;
import lotto.domain.WinningLottoNumbers;

public class LottoService {

    public static final int LOTTO_TICKET_PRICE = 1000;

    public LottoService() {
    }

    public LottoTickets buyLottoTickets(Money money) {
        int amount = getAmount(money);
        return LottoTickets.generateRandomLottoTickets(amount);
    }

    private int getAmount(Money money) {
        return money.getLottoAmount(LOTTO_TICKET_PRICE);
    }

    public GameResult getGameResult(LottoTickets lottoTickets, WinningLottoNumbers winningLottoNumbers) {
        return lottoTickets.getGameResult(winningLottoNumbers);
    }
}
