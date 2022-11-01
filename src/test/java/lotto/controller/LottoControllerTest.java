package lotto.controller;

import lotto.model.lotto.ticket.LottoNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class LottoControllerTest {
    @Test
    @DisplayName("LottoController 이상 없음 확인")
    void createLottoController() {
        final LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        assertDoesNotThrow(() -> new LottoController(lottoNumberGenerator));
    }
}
