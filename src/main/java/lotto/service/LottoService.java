package lotto.service;

import lotto.domain.GameResult;
import lotto.domain.LottoTickets;
import lotto.domain.Money;
import lotto.domain.WinningLottoNumbers;
import lotto.exception.NotEnoughMoneyException;

public class LottoService {

    public static final int LOTTO_TICKET_PRICE = 1000;

    public LottoService() {
    }

    public LottoTickets buyAutoLottoTickets(int countsOfAutoTickets) {
        return LottoTickets.generateRandomLottoTickets(countsOfAutoTickets);
    }

    public GameResult getGameResult(LottoTickets lottoTickets, WinningLottoNumbers winningLottoNumbers) {
        return lottoTickets.getGameResult(winningLottoNumbers);
    }

    public int getCountsOfAutoTickets(Money inputMoney, int countsOfManualTickets) {
        int countsOfAutoTickets = inputMoney.getLottoAmount(LOTTO_TICKET_PRICE) - countsOfManualTickets;
        if (countsOfAutoTickets < 0) {
            throw new NotEnoughMoneyException();
        }
        return countsOfAutoTickets;
    }
}
