package study.lottoAuto;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    public void run() {
        Money userInputMoney = readMoney();
        LottoNumbersGroup lottoNumbersGroup = generateLottoNumbersGroup(userInputMoney.getPurchaseCount());
        LottoNumbers lastWeekLottoNumbers = generateLastLottoNumbers();
        handleStatics(userInputMoney, lottoNumbersGroup, lastWeekLottoNumbers);
    }

    private Money readMoney() {
        OutputView.requestInputMoney();
        Money money = new Money(InputView.readMoney());
        OutputView.printPurchaseCount(money.getPurchaseCount());
        return money;
    }

    private LottoNumbersGroup generateLottoNumbersGroup(final int purchaseCount) {
        List<LottoNumbers> lottoNumbersList = new ArrayList<>();
        for(int i=0; i<purchaseCount; i++) {
            LottoNumbers lottoNumbers = new LottoNumbers();
            lottoNumbersList.add(lottoNumbers);
            OutputView.printLottoNumberGroup(lottoNumbers); // 출력하는 부분이 여기 있는게 좀 어색한듯...?
        }
        return new LottoNumbersGroup(lottoNumbersList);
    }

    private LottoNumbers generateLastLottoNumbers() {
        OutputView.requestLastLottoNumberGroup();
        return new LottoNumbers(InputView.readLastLottoNumbers());
    }

    private void handleStatics(Money userInputMoney, LottoNumbersGroup lottoNumbersGroup, LottoNumbers lastLottoNumbers) {
        StaticsController staticsController = new StaticsController(userInputMoney, lottoNumbersGroup, lastLottoNumbers);
        staticsController.analyst();
        OutputView.printStatics(staticsController.getStatics());
    }
}
