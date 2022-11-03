package lotto.controller;

import lotto.domain.LottoGame;
import lotto.view.LottoView;

public class AutoLottoController extends LottoController {

    public AutoLottoController(LottoGame lottoGame, LottoView view, Runnable bonusStrategy) {
        super(lottoGame, view, bonusStrategy);
    }
}
