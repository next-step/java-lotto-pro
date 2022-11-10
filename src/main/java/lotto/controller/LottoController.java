package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoNumber;
import lotto.model.LottoShop;
import lotto.model.Lottos;
import lotto.model.Money;
import lotto.model.Ranks;
import lotto.model.Winner;
import lotto.strategy.LottoRandomCreateStrategy;
import lotto.view.Input;
import lotto.view.Output;

public class LottoController {

    public static void main(String[] args) {
        Money payment = Input.inputPayment();
        Lottos manualLottos = new Lottos(getManualLottos());

        LottoShop lottoShop = new LottoShop(new LottoRandomCreateStrategy());
        Lottos autoLottos = lottoShop.buy(payment.minus(manualLottos.getTotalSpent()));

        Output.printLottos(manualLottos, autoLottos);

        Lotto winnerLotto = new Lotto(Input.inputWinnerLottoNumber());
        LottoNumber bonusNumber = Input.inputBonusNumber();
        Lottos lottos = manualLottos.merge(autoLottos);
        Ranks ranks = lottos.match(new Winner(winnerLotto, bonusNumber));

        Output.printResult(ranks);
    }

    private static List<Lotto> getManualLottos() {
        int lottoCount = Input.inputManualLottoNumbers();
        Output.requestManualLotto();
        List<Lotto> manualLottoList = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            manualLottoList.add(new Lotto(Input.inputManualLottoNumber()));
        }
        return manualLottoList;
    }
}
