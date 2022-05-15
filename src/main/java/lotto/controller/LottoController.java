package lotto.controller;


import calculator.utils.Splitter;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoStore;
import lotto.domain.Money;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public void startSales() {
        LottoStore lottoStore = new LottoStore(new Money(InputView.inputMoney()));
        OutputView.printLottoCount(lottoStore.getLottoCount());
        lottoStore.buy();

        OutputView.printLottoAutoNumbers(lottoStore.getLottoAutoNumbers());
        LottoNumbers winningNumbers = new LottoNumbers(Splitter.splitString(InputView.inputWinningNumbers()));
        
        lottoStore.calculateWinningResult(winningNumbers);
        OutputView.printLottoResult(lottoStore, lottoStore.getLottoResult());
    }
}
