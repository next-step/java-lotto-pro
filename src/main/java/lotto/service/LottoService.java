package lotto.service;

import lotto.domain.*;
import lotto.view.InputProvider;
import lotto.view.OutputProvider;

public class LottoService {
    private final LottoStore lottoStore = new LottoStore(new RandomLottoNumberGenerateStrategy());

    public void execute() {
        LottoPurchaseAmount lottoPurchaseAmount = new LottoPurchaseAmount(InputProvider.purchaseAmount());
        LottoTickets lottoTickets = lottoStore.buy((lottoPurchaseAmount.getQuantity()));
        OutputProvider.printLottoTicket(lottoTickets);
        WinningLottoNumber winningLottoNumber = new WinningLottoNumber(InputProvider.lottoNumbers(), InputProvider.bonusNumber());
        Rewards rewards = lottoTickets.check(winningLottoNumber);
        OutputProvider.printRewards(rewards);
    }
}
