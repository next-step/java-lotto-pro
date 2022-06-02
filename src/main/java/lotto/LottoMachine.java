package lotto;

import lotto.domain.Lottos;
import lotto.domain.vo.AutoGameCount;
import lotto.domain.vo.ManualGameCount;
import lotto.view.InputView;

import java.util.List;

public class LottoMachine {
    private final LottoNumberGenerator numberService = new LottoNumberGenerator();

    public Lottos purchase(ManualGameCount manualGameCount, AutoGameCount autoGameCount) {
        Lottos lottos = new Lottos();
        buyManualLottos(manualGameCount, lottos);
        buyAutoLottos(autoGameCount, lottos);
        return lottos;
    }

    private void buyManualLottos(ManualGameCount manualGameCount, Lottos lottos) {
        if (manualGameCount.getCount() <= 0) {
            return ;
        }

        InputView.printManualGame();
        for (int i = 0; i < manualGameCount.getCount(); i++) {
            List<Integer> manualNumbers = InputView.scanLottoNumber();
            lottos.addLotto(manualNumbers);
        }
    }

    private void buyAutoLottos(AutoGameCount autoGameCount, Lottos lottos) {
        for (int i = 0; i < autoGameCount.getCount(); i++) {
            List<Integer> lottoNumbers = numberService.makeLottoNumbers();
            lottos.addLotto(lottoNumbers);
        }
    }
}
