package study.lotto.controller;

import study.lotto.domain.*;
import study.lotto.view.InputView;
import study.lotto.view.OutputView;

public class LottoController {

    public void run() {
        Money userInputMoney = readMoney();
        LottoNumbersGroup lottoNumbersGroup = new LottoNumbersGroup(userInputMoney);
        OutputView.printLottoNumbersGroup(lottoNumbersGroup);

        lottoNumbersGroup.setWinningLottoNumbers(generateWinningLottoNumbers());
        lottoNumbersGroup.setBonusBall(generateBonusBall());

        OutputView.printStatics(Statics.valueOf(userInputMoney, lottoNumbersGroup));
    }

    private Money readMoney() {
        OutputView.requestInputMoney();
        Money money = new Money(InputView.readMoney());
        OutputView.printPurchaseCount(money.getPurchaseCount());
        return money;
    }

    private LottoNumbers generateWinningLottoNumbers() {
        OutputView.requestWinningLottoNumberGroup();
        return new LottoNumbers(InputView.readWinningLottoNumbers());
    }

    private LottoNumber generateBonusBall() {
        OutputView.requestBonusBall();
        return new LottoNumber(Integer.parseInt(InputView.readBonusBallNumber()));
    }
}
