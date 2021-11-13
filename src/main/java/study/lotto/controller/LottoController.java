package study.lotto.controller;

import study.lotto.domain.*;
import study.lotto.view.InputView;
import study.lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    public void run() {
        Money userInputMoney = readMoney();

        LottoNumbersGroup lottoNumbersGroup = generateLottoNumbersGroup(userInputMoney.getPurchaseCount());
        OutputView.printLottoNumbersGroup(lottoNumbersGroup);

        lottoNumbersGroup.setLastLastLottoNumbers(generateLastLottoNumbers());
        lottoNumbersGroup.setBonusBall(generateBonusBall());

        OutputView.printStatics(Statics.valueOf(userInputMoney, lottoNumbersGroup));
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

    private LottoNumber generateBonusBall() {
        OutputView.requestBonusBall();
        return new LottoNumber(InputView.readBonusBallNumber());
    }
}
