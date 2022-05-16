package lotto;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
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
        assertThatThrownBy(() -> game.setWinnerTicket("1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 지난주_당첨_번호_공백_입력() {
        List<LottoTicket> tickets = new ArrayList<>();
        tickets.add(new LottoTicket("1,2,3,4,5,6"));
        LottoGame game = new LottoGame(tickets, new LottoTicket("4, 5, 6, 7, 8, 9"));
        assertThat(game.getScore().get(3)).isEqualTo(1);
    }

    @Test
    void 지난주_당첨_번호_콤마_뒤_공백() {
        LottoGame game = new LottoGame(14000);
        game.setWinnerTicket("1, 2, 3, 4, 5, 6");

    }

    @Test
    void 지난주_당첨_번호_중복_입력() {
        LottoGame game = new LottoGame(14000);
        assertThatThrownBy(() -> game.setWinnerTicket("1,2,3,4,6,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 지난주_당첨_번호_숫자_범위_초과() {
        LottoGame game = new LottoGame(14000);
        assertThatThrownBy(() -> game.setWinnerTicket("-1,2,3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 번호_3개_일치() {
        List<LottoTicket> tickets = new ArrayList<>();
        tickets.add(new LottoTicket("1,2,3,4,5,6"));
        LottoGame game = new LottoGame(tickets, new LottoTicket("4,5,6,7,8,9"));
        assertThat(game.getScore().get(3)).isEqualTo(1);
    }

    @Test
    void 번호_3개_일치_2건() {
        List<LottoTicket> tickets = new ArrayList<>();
        tickets.add(new LottoTicket("1,2,3,4,5,6"));
        tickets.add(new LottoTicket("1,10,11,4,5,6"));
        tickets.add(new LottoTicket("1,12,13,14,5,6"));
        LottoGame game = new LottoGame(tickets, new LottoTicket("4,5,6,7,8,9"));
        assertThat(game.getScore().get(3)).isEqualTo(2);
    }

    @Test
    void 번호_4개_일치() {
        List<LottoTicket> tickets = new ArrayList<>();
        tickets.add(new LottoTicket("1,2,3,4,5,6"));
        LottoGame game = new LottoGame(tickets, new LottoTicket("1,2,3,4,8,9"));
        assertThat(game.getScore().get(4)).isEqualTo(1);
    }

    @Test
    void 번호_4개_일치_2건() {
        List<LottoTicket> tickets = new ArrayList<>();
        tickets.add(new LottoTicket("1,2,3,4,15,16"));
        tickets.add(new LottoTicket("11,12,3,4,5,6"));
        tickets.add(new LottoTicket("21,22,23,4,5,6"));
        LottoGame game = new LottoGame(tickets, new LottoTicket("1,2,3,4,5,6"));
        assertThat(game.getScore().get(4)).isEqualTo(2);
    }

    @Test
    void 번호_5개_일치() {
        List<LottoTicket> tickets = new ArrayList<>();
        tickets.add(new LottoTicket("1,2,3,4,5,6"));
        LottoGame game = new LottoGame(tickets, new LottoTicket("1,2,3,4,5,9"));
        assertThat(game.getScore().get(5)).isEqualTo(1);
    }

    @Test
    void 번호_5개_일치_2건() {
        List<LottoTicket> tickets = new ArrayList<>();
        tickets.add(new LottoTicket("1,2,3,4,5,16"));
        tickets.add(new LottoTicket("11,2,3,4,5,6"));
        tickets.add(new LottoTicket("21,32,3,4,5,6"));
        LottoGame game = new LottoGame(tickets, new LottoTicket("1,2,3,4,5,6"));
        assertThat(game.getScore().get(5)).isEqualTo(2);
    }

    @Test
    void 번호_6개_일치() {
        List<LottoTicket> tickets = new ArrayList<>();
        tickets.add(new LottoTicket("1,2,3,4,5,6"));
        LottoGame game = new LottoGame(tickets, new LottoTicket("1,2,3,4,5,6"));
        assertThat(game.getScore().get(6)).isEqualTo(1);
    }

    @Test
    void 번호_6개_일치_2건() {
        List<LottoTicket> tickets = new ArrayList<>();
        tickets.add(new LottoTicket("1,2,3,4,5,6"));
        tickets.add(new LottoTicket("1,2,3,4,5,6"));
        tickets.add(new LottoTicket("21,32,3,4,5,6"));
        LottoGame game = new LottoGame(tickets, new LottoTicket("1,2,3,4,5,6"));
        assertThat(game.getScore().get(6)).isEqualTo(2);
    }

    @Test
    void 총_수익률_5() {
        List<LottoTicket> tickets = new ArrayList<>();
        tickets.add(new LottoTicket("1,2,3,4,5,6"));
        LottoGame game = new LottoGame(tickets, new LottoTicket("4,5,6,7,8,9"));
        assertThat(game.getEarningRate()).isEqualTo(5.00);
    }

    @Test
    void 총_수익률_1보다_작은_경우() {
        List<LottoTicket> tickets = new ArrayList<>();
        tickets.add(new LottoTicket("1,2,3,4,5,6"));
        tickets.add(new LottoTicket("11,12,13,14,15,16"));
        tickets.add(new LottoTicket("11,12,13,14,15,16"));
        tickets.add(new LottoTicket("11,12,13,14,15,16"));
        tickets.add(new LottoTicket("11,12,13,14,15,16"));
        tickets.add(new LottoTicket("11,12,13,14,15,16"));
        tickets.add(new LottoTicket("11,12,13,14,15,16"));
        tickets.add(new LottoTicket("11,12,13,14,15,16"));
        tickets.add(new LottoTicket("11,12,13,14,15,16"));
        tickets.add(new LottoTicket("11,12,13,14,15,16"));
        LottoGame game = new LottoGame(tickets, new LottoTicket("4,5,6,7,8,9"));
        assertThat(game.getEarningRate()).isEqualTo(0.50);
    }
}
