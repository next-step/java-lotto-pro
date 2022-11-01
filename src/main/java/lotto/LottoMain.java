package lotto;

import java.util.List;
import java.util.stream.Collectors;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoResult;
import lotto.util.LottoUtil;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoMain {
    public static void main(String[] args) {
        Integer purchaseMoney = InputView.getPurchaseMoney();
        Integer manualCount = InputView.getManualCount();
        List<String> manualLottoNumbers = InputView.getManualLottoNumbers(manualCount);
        Lotto lotto = new Lotto(purchaseMoney, toLottoNumbersList(manualLottoNumbers));
        ResultView.printPurchaseNumbers(lotto.getLottoNumbersList(), manualCount);
        String winningNumbers = InputView.getWinningNumbers();
        Integer bonusNumber = InputView.getBonusNumber();
        LottoResult lottoResult = lotto.computeResult(LottoUtil.toLottoNumber(winningNumbers),
            new LottoNumber(bonusNumber));
        ResultView.printResult(lottoResult);
    }

    private static List<LottoNumbers> toLottoNumbersList(List<String> manualLottoNumbers) {
        return manualLottoNumbers.stream()
            .map(LottoUtil::toLottoNumber)
            .collect(Collectors.toList());
    }

}
