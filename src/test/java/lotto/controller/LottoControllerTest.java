package lotto.controller;

import lotto.controller.acceptor.MoneyToBuyAcceptor;
import lotto.controller.acceptor.WinningNumbersAcceptor;
import lotto.model.lotto.ticket.LottoNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class LottoControllerTest {
    @Test
    @DisplayName("LottoController 이상 없음 확인")
    void createLottoController() {
        final int[][] prizes = new int[][]{{3, 5000}, {4, 50000}, {5, 150000}, {6, 2000000000}};
        final MoneyToBuyAcceptor moneyToBuyAcceptor = new MoneyToBuyAcceptor();
        final LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        final WinningNumbersAcceptor winningNumbersAcceptor = new WinningNumbersAcceptor();
        assertDoesNotThrow(() -> new LottoController(prizes, moneyToBuyAcceptor, lottoNumberGenerator,
                winningNumbersAcceptor));
    }
}
