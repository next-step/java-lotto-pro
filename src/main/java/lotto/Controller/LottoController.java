package lotto.Controller;

import lotto.domain.*;
import lotto.utils.LottoUtils;
import lotto.view.LottoInputView;
import lotto.view.LottoOutPutView;

import java.util.List;

public class LottoController {

    public static void start() {
        Money money = new Money(LottoUtils.StringToInt(LottoInputView.readMoney()));
        int manulLottoCount = LottoUtils.StringToInt(LottoInputView.readManualLottoCount());
        Lottos manualLottos = Lottos.buyManualLottos(manulLottoCount);
        Lottos autoLottos = Lottos.buyAutoLottos(money.lottoCount()-manulLottoCount);
        LottoOutPutView.writeBuyLottos(manualLottos, autoLottos);
        Lotto winLotto = readWinLotto(LottoInputView.readLottoWinNumber());
        int bonusNumber = LottoUtils.StringToInt(LottoInputView.readBonusNumber());
        LottoNumber bonus = new LottoNumber(bonusNumber);
        winLotto.duplicateWinBonus(bonus);
        LottoResult result = new LottoResult(autoLottos, winLotto, money.totalLottoPrice(), bonus);
        LottoOutPutView.writeWinResult(result);
    }

    private static Lotto readWinLotto(String lottoWinNumber) {
        List<Integer> winLottoNumbers = LottoUtils.stringToLottoNumbers(lottoWinNumber);
        return new Lotto(winLottoNumbers);
    }
}
