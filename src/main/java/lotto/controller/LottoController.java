package lotto.controller;

import lotto.model.Counter;
import lotto.model.LottoList;
import lotto.model.LottoResult;
import lotto.model.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

  public void lotto() {
    generateLotto();
  }

  private void generateLotto() {
    LottoList lottoList = payToCounter();
    WinningLotto winningLotto = winningLottoNumber();
    generateLottoResult(lottoList, winningLotto);
  }

  private LottoList payToCounter() {
    Counter counter = new Counter(InputView.inputMoneyPurchaseLotto());
    LottoList lottoList = counter.getLottoList();
    OutputView.printCompletePurchaseLotto(lottoList);
    return lottoList;
  }

  private WinningLotto winningLottoNumber() {
    return new WinningLotto(InputView.innputWinningLottoNumber());
  }

  private void generateLottoResult(LottoList lottoList, WinningLotto winningLotto) {
    OutputView.printResultHead();
    LottoResult lottoResult = new LottoResult(lottoList, winningLotto);
    OutputView.printLottoResult(lottoResult);
  }

}
