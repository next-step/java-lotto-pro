package lotto.controller;

import lotto.controller.acceptor.MoneyToBuyAcceptor;
import lotto.controller.acceptor.WinningNumbersAcceptor;
import lotto.model.lotto.enums.LottoNumberMatchCount;
import lotto.model.lotto.enums.LottoRank;
import lotto.model.lotto.ticket.LottoNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class LottoControllerTest {
    @Test
    @DisplayName("LottoController 이상 없음 확인")
    void createLottoController() {
        final Map<LottoNumberMatchCount, Integer> prizes = new HashMap<>();
        prizes.put(LottoRank.FOURTH.matchCount(), LottoRank.FOURTH.prizeMoney());
        prizes.put(LottoRank.THIRD.matchCount(), LottoRank.THIRD.prizeMoney());
        prizes.put(LottoRank.SECOND.matchCount(), LottoRank.SECOND.prizeMoney());
        prizes.put(LottoRank.FIRST.matchCount(), LottoRank.FIRST.prizeMoney());
        final MoneyToBuyAcceptor moneyToBuyAcceptor = new MoneyToBuyAcceptor();
        final LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        final WinningNumbersAcceptor winningNumbersAcceptor = new WinningNumbersAcceptor();
        assertDoesNotThrow(() -> new LottoController(prizes, moneyToBuyAcceptor, lottoNumberGenerator,
                winningNumbersAcceptor));
    }
}
