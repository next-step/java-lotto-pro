package lotto.controller;

import lotto.domain.Number;
import lotto.domain.*;
import lotto.view.LottoView;

import java.util.List;

public class LottoController {
    private static final LottoView view = new LottoView();

    public static void main(String[] args) {
        LottoCharge charge = LottoCharge.from(view.inputCharge());
        ManualCount count = ManualCount.from(view.inputManualCount());
        LottoCharge restCharge = charge.spend(count);

        view.inputManualNumbersMessage();
        List<Lotto> manualLottos = count.toList(() -> Lotto.manual(view.inputManualNumbers()));

        Lottos lottos = Lottos.buy(manualLottos, restCharge);
        view.showLottos(count, restCharge, lottos);

        Lotto answer = new Lotto(view.inputAnswer());
        Number bonus = Number.from(view.inputBonus());
        Winnings winnings = lottos.winnigs(new Answer(answer, bonus));

        view.showStatistics(Statistics.of(charge, winnings));
    }
}
