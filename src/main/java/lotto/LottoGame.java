package lotto;

import lotto.domain.LottoBundle;
import lotto.domain.LottoNumber;
import lotto.domain.LottoResult;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.LottoView;

import java.util.List;

public class LottoGame {

    public void play() {
        Money money = InputView.getUserMoney();

        int customLottoCount;
        do {
            customLottoCount = InputView.getCustomLottoCount();
        } while (checkAbleToBuyCustomLotto(money, customLottoCount));

        LottoBundle customLottoBundle = money.buyCustomLotto(InputView.getCustomLottoNumbersBundle(customLottoCount), customLottoCount);
        LottoBundle lottoBundle = money.buyAllRandomLotto();

        LottoView.printLottoBundleStatus(customLottoBundle, lottoBundle);

        LottoBundle totalLottoBundle = lottoBundle.addAll(customLottoBundle);

        WinningLotto winningLotto = InputView.getWinningLotto();

        LottoResult lottoResult = totalLottoBundle.getLottoResult(winningLotto);

        LottoView.printResult(lottoResult);
    }

    private boolean checkAbleToBuyCustomLotto(Money money, int customLottoCount) {
        if (money.isAbleToBuyCustomLotto(customLottoCount)) {
            return false;
        }

        LottoView.printErrorToBuyCustomLotto();
        return true;
    }
}
