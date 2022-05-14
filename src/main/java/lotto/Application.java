package lotto;

import lotto.domain.LottoNumbers;
import lotto.domain.LottoPrice;
import lotto.domain.LottoStatistics;
import lotto.ui.InputView;
import lotto.ui.ResultView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        LottoApplication lottoApplication = new LottoApplication();

        initLotto(inputView, resultView, lottoApplication);
        generateLottoNumber(resultView, lottoApplication);
        generateWinningNumber(inputView, resultView, lottoApplication);
        statistics(resultView, lottoApplication);
    }

    private static void initLotto(InputView inputView, ResultView resultView, LottoApplication lottoApplication) {
        resultView.printInputPrice();
        Integer price = inputView.inputPrice();
        LottoPrice lottoPrice = lottoApplication.purchase(price);
        resultView.printLottoCount(lottoPrice);
    }

    private static void generateLottoNumber(ResultView resultView, LottoApplication lottoApplication) {
        List<LottoNumbers> lottoNumbers = lottoApplication.generateLottoNumbers();
        resultView.printLottoNumbers(lottoNumbers);
    }

    private static void generateWinningNumber(InputView inputView, ResultView resultView, LottoApplication lottoApplication) {
        resultView.printInputWinningNumbers();
        List<Integer> winningNumbers = inputView.inputWinningNumbers();
        lottoApplication.setWinningNumbers(winningNumbers);
    }

    private static void statistics(ResultView resultView, LottoApplication lottoApplication) {
        LottoStatistics lottoStatistics = lottoApplication.calculateStatistics();
        resultView.printStatistics(lottoStatistics);
    }
}
