package lotto.Controller;

import lotto.domain.Lotto;
import lotto.domain.LottoCreator;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.utils.LottoUtils;
import lotto.view.LottoInputView;
import lotto.view.LottoOutPutView;

import java.util.List;

public class LottoController {

    public static void start() {
        Money money = new Money(Integer.parseInt(LottoInputView.readMoney()));
        Lottos lottos = LottoCreator.buyLottos(money.lottoCount());
        LottoOutPutView.writeBuyLottos(lottos);
        Lotto winLotto = readWinLotto(LottoInputView.readLottoWinNumber());
    }

    private static Lotto readWinLotto(String lottoWinNumber) {
        List<Integer> winLottoNumbers = LottoUtils.stringToLottoNumbers(lottoWinNumber);
        return new Lotto(winLottoNumbers);
    }
}
