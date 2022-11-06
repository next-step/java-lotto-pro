package lotto.controller;

import lotto.controller.acceptor.MoneyToBuyAcceptor;
import lotto.controller.acceptor.WinningNumbersAcceptor;
import lotto.model.lotto.enums.LottoNumberMatchCount;
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
        prizes.put(LottoNumberMatchCount.THREE, 5000);
        prizes.put(LottoNumberMatchCount.FOUR, 50000);
        prizes.put(LottoNumberMatchCount.FIVE, 150000);
        prizes.put(LottoNumberMatchCount.SIX, 2000000000);
        final MoneyToBuyAcceptor moneyToBuyAcceptor = new MoneyToBuyAcceptor();
        final LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        final WinningNumbersAcceptor winningNumbersAcceptor = new WinningNumbersAcceptor();
        assertDoesNotThrow(() -> new LottoController(prizes, moneyToBuyAcceptor, lottoNumberGenerator,
                winningNumbersAcceptor));
    }
}
