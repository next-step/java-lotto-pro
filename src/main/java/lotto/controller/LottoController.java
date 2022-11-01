package lotto.controller;

import java.util.Map;
import lotto.domain.Amount;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoRank;
import lotto.domain.Lottos;
import lotto.domain.WinningLotto;
import lotto.service.LottoService;

public class LottoController {

    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void start() {
        Amount buyAmount = lottoService.buyLottoAuto();
        Lottos buyLottos = lottoService.generateLottos(buyAmount);
        WinningLotto winningLotto = lottoService.winningLotto();
        Map<LottoRank, Integer> rankInfo = lottoService.checkWinnginLotto(buyLottos, winningLotto);
        lottoService.calculateLottoYield(buyAmount, rankInfo);
    }
}
