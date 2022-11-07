package lotto;

import lotto.controller.LottoController;
import lotto.controller.acceptor.BonusAcceptor;
import lotto.controller.acceptor.MoneyToBuyAcceptor;
import lotto.controller.acceptor.WinningNumbersAcceptor;
import lotto.model.lotto.enums.LottoNumberMatchCount;
import lotto.model.lotto.enums.LottoRank;
import lotto.model.lotto.ticket.LottoNumberGenerator;

import java.util.HashMap;
import java.util.Map;

public class MainApplication {
    public static void main(String[] args) {
        final Map<LottoNumberMatchCount, Integer> prizeMoney = new HashMap<>();
        prizeMoney.put(LottoRank.FOURTH.matchCount(), LottoRank.FOURTH.prizeMoney());
        prizeMoney.put(LottoRank.THIRD.matchCount(), LottoRank.THIRD.prizeMoney());
        prizeMoney.put(LottoRank.SECOND.matchCount(), LottoRank.SECOND.prizeMoney());
        prizeMoney.put(LottoRank.FIRST.matchCount(), LottoRank.FIRST.prizeMoney());
        final MoneyToBuyAcceptor moneyToBuyAcceptor = new MoneyToBuyAcceptor();
        final LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        final WinningNumbersAcceptor winningNumbersAcceptor = new WinningNumbersAcceptor();
        final BonusAcceptor bonusAcceptor = new BonusAcceptor();
        final LottoController lottoController = new LottoController(prizeMoney, moneyToBuyAcceptor,
                lottoNumberGenerator, winningNumbersAcceptor, bonusAcceptor);
        lottoController.run();
    }
}
