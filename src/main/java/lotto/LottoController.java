package lotto;

import lotto.generator.AutoLottoGenerator;
import lotto.generator.LottoGenerator;
import lotto.model.LottoBuyer;
import lotto.model.LottoDrawer;

import static lotto.view.InputView.*;

public class LottoController {
  public static void run() {
    LottoGenerator lottoGenerator = getAutoLottoGenerator();
    LottoBuyer lottoBuyer = LottoBuyer.buy(inputPurchaseAmount(), lottoGenerator);
    LottoDrawer lottoDrawer = LottoDrawer.draw(lottoGenerator);
    LottoMachine lottoMachine = new LottoMachine(lottoDrawer, lottoBuyer);

    lottoMachine.execute();
  }

  private static AutoLottoGenerator getAutoLottoGenerator() {
    return new AutoLottoGenerator();
  }
}
