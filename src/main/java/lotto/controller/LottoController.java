package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.utils.CustomParseUtils;
import lotto.generator.LottosGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;
import java.util.List;

public class LottoController {
    public static void simulateLotto(){
        Money money = new Money(CustomParseUtils.stringToInteger(InputView.readMoney()));
        Lottos lottos = LottosGenerator.purchaseLottos(money);
        OutputView.printPurchasedLottos(lottos);

        Lotto winningLotto = generateWinningLotto();
        LottoResult result = new LottoResult(lottos, winningLotto);
        OutputView.printLottoResult(result, money.calculateProfit(result.winningPrice()));
    }

    private static Lotto generateWinningLotto(){
        List<Integer> winningNumbers = CustomParseUtils.stringToIntegerList(InputView.readLottoWinningNumber());
        return new Lotto(winningNumbers);
    }
}
