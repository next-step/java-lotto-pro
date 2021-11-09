package study.lottoAuto;

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
