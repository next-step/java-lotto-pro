package lotto.Controller;

import lotto.domain.*;
import lotto.utils.LottoUtils;
import lotto.view.LottoInputView;
import lotto.view.LottoOutPutView;

import java.util.List;

public class LottoController {

    public static void start() {
        Money money = new Money(LottoUtils.stringToMoney(LottoInputView.readMoney()));
        Lottos lottos = Lottos.buyLottos(money.lottoCount());
        LottoOutPutView.writeBuyLottos(lottos);
        Lotto winLotto = readWinLotto(LottoInputView.readLottoWinNumber());
        LottoResult result = new LottoResult(lottos, winLotto, money.totalLottoPrice());
        LottoOutPutView.writeWinResult(result);
    }

    private static Lotto readWinLotto(String lottoWinNumber) {
        List<Integer> winLottoNumbers = LottoUtils.stringToLottoNumbers(lottoWinNumber);
        return new Lotto(winLottoNumbers);
    }
}
