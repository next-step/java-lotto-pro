package lotto.service;

import lotto.domain.*;
import lotto.view.InputProvider;
import lotto.view.OutputProvider;

public class LottoService {
    private final LottoStore lottoStore = new LottoStore(new RandomLottoNumberGenerateStrategy());

    public void execute() {
        LottoTickets lottoTickets = buyTickets(new LottoPurchaseAmount(InputProvider.purchaseAmount()));
        OutputProvider.printLottoTicket(lottoTickets);
        WinningLottoNumber winningNumbers = new WinningLottoNumber(InputProvider.lottoNumbers(), InputProvider.bonusNumber());
        Rewards rewards = lottoTickets.check(winningNumbers);
        OutputProvider.printRewards(rewards);
    }

    private LottoTickets buyTickets(LottoPurchaseAmount lottoPurchaseAmount) {
        LottoTickets manualLottoTickets = lottoStore.buy(InputProvider.manualLottoNumbers(InputProvider.manualLottoCount()));
        LottoPurchaseAmount change = lottoPurchaseAmount.pay(manualLottoTickets.getTicketCount());
        LottoTickets autoLottoTickets = lottoStore.buy((change.getQuantity()));
        OutputProvider.printTicketCount(manualLottoTickets.getTicketCount(), autoLottoTickets.getTicketCount());
        return manualLottoTickets.merge(autoLottoTickets);
    }
}
