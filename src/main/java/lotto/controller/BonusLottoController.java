package lotto.controller;

import lotto.domain.LottoGame;
import lotto.view.LottoView;

public class BonusLottoController extends LottoController {

    public BonusLottoController(LottoGame lottoGame, LottoView view, Runnable bonusStrategy) {
        super(lottoGame, view, bonusStrategy);
    }
}
