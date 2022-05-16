package lotto;

import lotto.domain.LottoNumbers;
import lotto.domain.LottoPrice;
import lotto.domain.LottoStatistics;
import lotto.domain.WinningLottoNumber;
import lotto.ui.InputView;
import lotto.ui.ResultView;

import java.util.List;

public class Application {
    private static final InputView inputView = new InputView();
    private static final ResultView resultView = new ResultView();
    private static final LottoApplication lottoApplication = new LottoApplication();

    public static void main(String[] args) {
        initLotto();
        generateWinningNumber();
        statistics();
    }

    private static void initLotto() {
        Integer price = inputView.inputPrice();
        Integer manualCount = inputView.inputManualCount();
        LottoPrice lottoPrice = lottoApplication.purchase(price, manualCount);

        List<List<Integer>> manualLottoNumbers = inputView.inputManualLottoNumbers(manualCount);
        resultView.printLottoCount(lottoPrice);
        List<LottoNumbers> lottoNumbers = lottoApplication.generateLottoNumbers(manualLottoNumbers);

        resultView.printLottoNumbers(lottoNumbers);
    }

    private static void generateWinningNumber() {
        List<Integer> winningNumbers = inputView.inputWinningNumbers();
        Integer winningBonusNumber = inputView.inputWinningBonusNumber();
        lottoApplication.setWinningNumbers(new WinningLottoNumber(winningNumbers, winningBonusNumber));
    }

    private static void statistics() {
        LottoStatistics lottoStatistics = lottoApplication.calculateStatistics();
        resultView.printStatistics(lottoStatistics);
    }
}
