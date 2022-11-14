package lotto.Controller;

import lotto.domain.*;
import lotto.utils.LottoUtils;
import lotto.view.LottoInputView;
import lotto.view.LottoOutPutView;

import java.util.List;

public class LottoController {

    public static void start() {
        Money money = new Money(LottoUtils.StringToInt(LottoInputView.readMoney()));
        int manualLottoCount = LottoUtils.StringToInt(LottoInputView.readManualLottoCount());
        money.checkManualLottoCount(manualLottoCount);
        Lottos manualLottos = Lottos.buyManualLottos(LottoInputView.readManualLotto(manualLottoCount));
        Lottos autoLottos = Lottos.buyAutoLottos(money.lottoTotalCount()-manualLottoCount);
        Lottos totalLottos = Lottos.mergeLottos(manualLottos, autoLottos);
        LottoOutPutView.writeBuyLottos(manualLottos, autoLottos);
        Lotto winLotto = readWinLotto(LottoInputView.readLottoWinNumber());
        int bonusNumber = LottoUtils.StringToInt(LottoInputView.readBonusNumber());
        LottoNumber bonus = new LottoNumber(bonusNumber);
        winLotto.duplicateWinBonus(bonus);
        LottoResult result = new LottoResult(totalLottos, winLotto, money.totalLottoPrice(), bonus);
        LottoOutPutView.writeWinResult(result);
    }


    private static Lotto readWinLotto(String lottoWinNumber) {
        List<Integer> winLottoNumbers = LottoUtils.stringToLottoNumbers(lottoWinNumber);
        return new Lotto(winLottoNumbers);
    }
}
