package lotto.controller;

import java.util.ArrayList;
import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.LottoFactory;
import lotto.domain.LottoMoney;
import lotto.domain.LottoReports;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTypesCount;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {
    public void start() {
        LottoMoney lottoMoney = InputView.inputLottoAmount();
        List<Lotto> manualLottos = InputView.createManualLottos();
        LottoTicket lottoTicket = buyLottoTicket(lottoMoney.getCountOfPossibleLotto(), manualLottos);
        OutputView.printLottoTickets(lottoTicket);
        WinningLotto winningLotto = InputView.createWinningLotto();
        LottoReports lottoReports = new LottoReports(lottoTicket.createWinningRanks(winningLotto), lottoMoney);
        OutputView.printLottoReports(lottoReports);
    }

    private LottoTicket buyLottoTicket(int countOfPossibleLotto, List<Lotto> manualLottos) {
        List<Lotto> lottos = new ArrayList<>(manualLottos);
        int manualLottosCount = manualLottos.size();
        int autoLottosCount = countOfPossibleLotto - manualLottosCount;
        for (int i = 0; i < autoLottosCount; i++) {
            lottos.add(LottoFactory.createLotto());
        }
        return new LottoTicket(lottos, new LottoTypesCount(manualLottosCount, autoLottosCount));
    }
}
