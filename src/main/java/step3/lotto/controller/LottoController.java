package step3.lotto.controller;

import java.io.IOException;
import step3.lotto.domain.customer.Customer;
import step3.lotto.domain.lotto.Lotto;
import step3.lotto.domain.lotto.MatchStatistic;
import step3.lotto.service.LottoService;
import step3.lotto.view.InputView;
import step3.lotto.view.ResultView;
import step3.lotto.view.reader.InputReader;

/**
 * @author : choi-ys
 * @date : 2022/05/17 2:16 오후
 */
public class LottoController {

    public void run() throws IOException {
        InputReader inputReader = new InputReader();
        Customer customer = new Customer(inputReader.inputPrice());
        InputView.printPurchaseCompletionAndPublishedLottosGuidMessage(customer);
        Lotto lastWinningLotto = inputReader.inputLastWinningLotto();

        LottoService lottoService = new LottoService();
        MatchStatistic matchStatistic = lottoService.play(customer, lastWinningLotto);
        ResultView.printWinningStatistics(matchStatistic);
    }
}
