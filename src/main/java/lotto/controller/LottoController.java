package lotto.controller;

import lotto.domain.*;
import lotto.view.LottoView;

public class LottoController {
    private static final LottoView view = new LottoView();

    public static void main(String[] args) {
        LottoCharge charge = LottoCharge.from(view.inputCharge());
        Lottos lottos = Lottos.buy(charge);
        view.showLottos(lottos);

        Lotto answer = new Lotto(view.inputAnswer());
        Winnings winnings = lottos.winnigs(answer);

        view.showStatistics(Statistics.of(charge, winnings));
    }
}
