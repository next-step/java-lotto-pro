package lotto.model;

import lotto.generator.LottoGenerator;

import static lotto.view.OutputView.*;

public class LottoDrawer {
  private final Lotto lotto;

  private LottoDrawer(Lotto lotto) {
    this.lotto = lotto;
  }

  public static LottoDrawer draw(LottoGenerator lottoGenerator) {
    Lotto lotto = lottoGenerator.generate();
    printDrawnLotto(lotto);
    return new LottoDrawer(lotto);
  }

  public Lotto getLotto() {
    return lotto;
  }
}
