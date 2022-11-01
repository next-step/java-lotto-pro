package lotto.model.lotto.ticket;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class LottoTicketTest {
    @RepeatedTest(value = 100)
    @DisplayName("LottoTicket 객체 생성 성공")
    void success() {
        final LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        assertDoesNotThrow(() -> new LottoTicket(lottoNumberGenerator));
    }
}
