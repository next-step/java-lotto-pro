package lotto.controller;

import static lotto.util.LottoUtil.splitInputWinningNumber;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.model.money.Money;
import lotto.model.number.LottoNumber;
import lotto.model.number.LottoNumbers;
import lotto.model.purchased.PurchasedInfo;
import lotto.model.purchased.PurchasedLotto;
import lotto.model.result.LottoResult;
import lotto.type.LottoWinningPriceType;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoMachine {

    public void start() {
        Money purchasedMoney = new Money(InputView.inputPurchasedMoney());

        PurchasedInfo purchasedInfo = new PurchasedInfo(purchasedMoney);
        OutputView.OutputPurchaseResult(purchasedInfo);

        LottoNumbers winningNumbers = new LottoNumbers(getInputWinningNumberArr());

        Map<LottoWinningPriceType, List<PurchasedLotto>> lottoWinningPriceTypeListMap =
            purchasedInfo.winningLotto(winningNumbers);

        LottoResult lottoStatistics = new LottoResult(lottoWinningPriceTypeListMap, purchasedMoney);
        OutputView.OutputLottoResult(lottoStatistics);
    }

    private List<LottoNumber> getInputWinningNumberArr() {
        String inputWinningNumber = InputView.inputWinningNumber();
        String[] inputWinningNumbers = splitInputWinningNumber(inputWinningNumber);

        return Arrays.stream(inputWinningNumbers)
            .map(LottoNumber::new)
            .collect(Collectors.toList());
    }

}
