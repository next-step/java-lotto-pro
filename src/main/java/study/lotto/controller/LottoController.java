package study.lotto.controller;

import study.lotto.domain.LottoNumbers;
import study.lotto.domain.LottoNumbersGroup;
import study.lotto.domain.Money;
import study.lotto.domain.Statics;
import study.lotto.view.InputView;
import study.lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    public void run() {
        Money userInputMoney = readMoney();

        LottoNumbersGroup lottoNumbersGroup = generateLottoNumbersGroup(userInputMoney.getPurchaseCount());
        OutputView.printLottoNumbersGroup(lottoNumbersGroup);

        LottoNumbers lastWeekLottoNumbers = generateLastLottoNumbers();

        Statics statics = handleStatics(userInputMoney, lottoNumbersGroup, lastWeekLottoNumbers);
        OutputView.printStatics(statics);
    }

    private Money readMoney() {
        OutputView.requestInputMoney();
        Money money = new Money(InputView.readMoney());
        OutputView.printPurchaseCount(money.getPurchaseCount());
        return money;
    }

    private LottoNumbersGroup generateLottoNumbersGroup(final int purchaseCount) {
        List<LottoNumbers> lottoNumbersList = new ArrayList<>();
        for(int i = 0; i < purchaseCount; i++) {
            LottoNumbers lottoNumbers = new LottoNumbers();
            lottoNumbersList.add(lottoNumbers);
        }
        return new LottoNumbersGroup(lottoNumbersList);
    }

    private LottoNumbers generateLastLottoNumbers() {
        OutputView.requestLastLottoNumberGroup();
        return new LottoNumbers(InputView.readLastLottoNumbers());
    }

    private Statics handleStatics(Money userInputMoney, LottoNumbersGroup lottoNumbersGroup, LottoNumbers lastLottoNumbers) {
        Statics statics = new Statics(userInputMoney, lottoNumbersGroup, lastLottoNumbers);
        statics.analyst();
        return statics;
    }
}
