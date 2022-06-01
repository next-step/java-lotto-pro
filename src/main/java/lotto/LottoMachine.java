package lotto;

import lotto.domain.Lottos;
import lotto.view.InputView;

import java.util.List;

public class LottoMachine {
    private final LottoNumberGenerator numberService = new LottoNumberGenerator();

    public Lottos purchase(int countOfManualCount, int countOfAutoGame) {
        Lottos lottos = new Lottos();
        buyManualLottos(countOfManualCount, lottos);
        buyAutoLottos(countOfAutoGame, lottos);
        return lottos;
    }

    private void buyManualLottos(int countOfManualCount, Lottos lottos) {
        if (countOfManualCount <= 0) {
            return ;
        }

        InputView.printManualGame();
        for (int i = 0; i < countOfManualCount; i++) {
            List<Integer> manualNumbers = InputView.scanLottoNumber();
            lottos.addLotto(manualNumbers);
        }
    }

    private void buyAutoLottos(int purchasingCount, Lottos lottos) {
        for (int i = 0; i < purchasingCount; i++) {
            List<Integer> lottoNumbers = numberService.makeLottoNumbers();
            lottos.addLotto(lottoNumbers);
        }
    }
}
