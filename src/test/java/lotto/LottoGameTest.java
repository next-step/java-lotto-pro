package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoGameTest {

    @Test
    void 구입금액이_음수인_경우() {
        assertThatThrownBy(() -> new LottoGame(-1))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void 구매장수_계산() {
        LottoGame game = new LottoGame(9999);
        assertEquals(game.getTicketCount(), 9);
    }

}
