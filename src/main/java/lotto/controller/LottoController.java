package lotto.controller;

import lotto.exception.LottoException;
import lotto.model.Counter;
import lotto.model.LottoList;
import lotto.model.LottoResult;
import lotto.model.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

  public void lotto() {
    Counter counter = payToCounterTemp();
    OutputView.printCompletePurchaseLotto(counter);
    WinningLotto winningLotto = winningLottoNumber();
    generateLottoResult(counter.getLottoList(), winningLotto);
  }

  private Counter payToCounterTemp() {
    try {
      Counter counter = new Counter(InputView.inputMoneyPurchaseLotto());
      counter.issueLotto(InputView.inputManualPurchaseLotto());
      return counter;
    } catch (LottoException lottoException) {
      OutputView.printErrorMessage(lottoException);
      return payToCounterTemp();
    }
  }

  private WinningLotto winningLottoNumber() {
    try {
      return new WinningLotto(InputView.inputWinningLottoNumber(),
          InputView.inputBonusLottoNumber());
    } catch (LottoException lottoException) {
      OutputView.printErrorMessage(lottoException);
      return winningLottoNumber();
    }
  }

  private void generateLottoResult(LottoList lottoList, WinningLotto winningLotto) {
    OutputView.printResultHead();
    LottoResult lottoResult = new LottoResult(lottoList, winningLotto);
    OutputView.printLottoResult(lottoResult);
  }

}
