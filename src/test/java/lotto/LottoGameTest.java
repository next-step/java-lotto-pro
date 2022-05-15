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

    @Test
    void 지난주_당첨_번호_5개만_입력() {
        LottoGame game = new LottoGame(14000);
        assertThatThrownBy(() -> game.setWinnerNumbers("1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 지난주_당첨_번호_공백_입력() {
        LottoGame game = new LottoGame(14000);
        assertThatThrownBy(() -> game.setWinnerNumbers("1,2,3,,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 지난주_당첨_번호_중복_입력() {
        LottoGame game = new LottoGame(14000);
        assertThatThrownBy(() -> game.setWinnerNumbers("1,2,3,4,6,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 지난주_당첨_번호_숫자_범위_초과() {
        LottoGame game = new LottoGame(14000);
        assertThatThrownBy(() -> game.setWinnerNumbers("-1,2,3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
