package step3.lotto.controller;

import step3.lotto.domain.customer.Customer;
import step3.lotto.domain.lotto.MatchStatistic;
import step3.lotto.domain.lotto.Winnings;
import step3.lotto.service.LottoService;
import step3.lotto.view.ResultView;
import step3.lotto.view.reader.InputReader;

/**
 * @author : choi-ys
 * @date : 2022/05/17 2:16 오후
 */
public class LottoController {

    public void run() {
        Customer customer = InputReader.InputCustomer();
        Winnings winnings = InputReader.inputWinnings();

        LottoService lottoService = new LottoService();
        MatchStatistic matchStatistic = lottoService.play(customer, winnings);
        ResultView.printWinningStatistics(matchStatistic);
    }
}
