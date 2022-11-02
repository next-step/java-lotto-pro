package lotto;

import lotto.controller.LottoController;
import lotto.controller.acceptor.MoneyToBuyAcceptor;
import lotto.controller.acceptor.WinningNumbersAcceptor;
import lotto.model.lotto.ticket.LottoNumberGenerator;

public class MainApplication {
    public static void main(String[] args) {
        final int[][] prizes = new int[][]{{3, 5000}, {4, 50000}, {5, 150000}, {6, 2000000000}};
        final MoneyToBuyAcceptor moneyToBuyAcceptor = new MoneyToBuyAcceptor();
        final LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        final WinningNumbersAcceptor winningNumbersAcceptor = new WinningNumbersAcceptor();
        final LottoController lottoController = new LottoController(prizes, moneyToBuyAcceptor, lottoNumberGenerator,
                winningNumbersAcceptor);
        lottoController.run();
    }
}
