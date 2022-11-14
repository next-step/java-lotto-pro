package lotto.service;

import lotto.domain.*;
import lotto.view.InputProvider;
import lotto.view.OutputProvider;

import java.util.List;

public class LottoService {
    private final LottoStore lottoStore = new LottoStore(new RandomLottoNumberGenerateStrategy());

    public void execute() {
        LottoTickets lottoTickets = buyTickets(new Money(InputProvider.purchaseAmount()));
        OutputProvider.printLottoTicket(lottoTickets);
        WinningLottoNumber winningNumbers = new WinningLottoNumber(InputProvider.lottoNumbers(), InputProvider.bonusNumber());
        Rewards rewards = lottoTickets.check(winningNumbers);
        OutputProvider.printRewards(rewards);
    }

    private LottoTickets buyTickets(Money lottoPurchaseAmount) {
        LottoTickets manualLottoTickets = lottoStore.buy(InputProvider.manualLottoNumbers(InputProvider.manualLottoCount()));
        Money change = lottoPurchaseAmount.payForTickets(manualLottoTickets.getTicketCount());
        LottoTickets autoLottoTickets = lottoStore.buy(change);
        OutputProvider.printTicketCount(manualLottoTickets.getTicketCount(), autoLottoTickets.getTicketCount());
        return manualLottoTickets.merge(autoLottoTickets);
    }
}
