package lotto;

import lotto.controller.LottoController;
import lotto.controller.acceptor.MoneyToBuyAcceptor;
import lotto.controller.acceptor.WinningNumbersAcceptor;
import lotto.model.lotto.enums.LottoNumberMatchCount;
import lotto.model.lotto.ticket.LottoNumberGenerator;

import java.util.HashMap;
import java.util.Map;

public class MainApplication {
    public static void main(String[] args) {
        final Map<LottoNumberMatchCount, Integer> prizeMoney = new HashMap<>();
        prizeMoney.put(LottoNumberMatchCount.THREE, 5000);
        prizeMoney.put(LottoNumberMatchCount.FOUR, 50000);
        prizeMoney.put(LottoNumberMatchCount.FIVE, 150000);
        prizeMoney.put(LottoNumberMatchCount.SIX, 2000000000);
        final MoneyToBuyAcceptor moneyToBuyAcceptor = new MoneyToBuyAcceptor();
        final LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        final WinningNumbersAcceptor winningNumbersAcceptor = new WinningNumbersAcceptor();
        final LottoController lottoController = new LottoController(prizeMoney, moneyToBuyAcceptor,
                lottoNumberGenerator, winningNumbersAcceptor);
        lottoController.run();
    }
}
