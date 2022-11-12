package lotto.Controller;

import lotto.domain.*;
import lotto.utils.LottoUtils;
import lotto.view.LottoInputView;
import lotto.view.LottoOutPutView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    public static void start() {
        Money money = new Money(LottoUtils.StringToInt(LottoInputView.readMoney()));
        int manualLottoCount = LottoUtils.StringToInt(LottoInputView.readManualLottoCount());
        Lottos manualLottos = readBuyManualLottos(manualLottoCount, LottoInputView.readManualLotto(manualLottoCount));
        Lottos autoLottos = Lottos.buyAutoLottos(money.lottoCount()-manualLottoCount);
        Lottos totalLottos = Lottos.mergeLottos(manualLottos, autoLottos);
        LottoOutPutView.writeBuyLottos(manualLottos, autoLottos);
        Lotto winLotto = readWinLotto(LottoInputView.readLottoWinNumber());
        int bonusNumber = LottoUtils.StringToInt(LottoInputView.readBonusNumber());
        LottoNumber bonus = new LottoNumber(bonusNumber);
        winLotto.duplicateWinBonus(bonus);
        LottoResult result = new LottoResult(totalLottos, winLotto, money.totalLottoPrice(), bonus);
        LottoOutPutView.writeWinResult(result);
    }

    private static Lottos readBuyManualLottos(int manualLottoCount, List<String> readManualLotto) {
        List<Lotto> manualLottos = new ArrayList<>();
        for (int i  = 0; i < manualLottoCount; i++){
            List<Integer> manualLotto = LottoUtils.stringToLottoNumbers(readManualLotto.get(i));
            manualLottos.add(new Lotto(manualLotto));
        }
        return new Lottos(manualLottos);
    }

    private static Lotto readWinLotto(String lottoWinNumber) {
        List<Integer> winLottoNumbers = LottoUtils.stringToLottoNumbers(lottoWinNumber);
        return new Lotto(winLottoNumbers);
    }
}
