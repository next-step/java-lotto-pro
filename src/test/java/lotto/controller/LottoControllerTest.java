package lotto.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class LottoControllerTest {
    @Test
    @DisplayName("LottoController 이상 없음 확인")
    void createLottoController() {
        assertDoesNotThrow(LottoController::new);
    }
}
