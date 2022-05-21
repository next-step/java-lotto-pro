package lotto;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class WinnerTicketTest {

    @Test
    void 지난주_당첨_번호_5개만_입력() {
        assertThatThrownBy(() -> new WinnerTicket("1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 지난주_당첨_번호_공백_입력() {
        List<LottoTicket> tickets = new ArrayList<>();
        List<LottoNumber> numbers = Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3)
                , new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
        tickets.add(new LottoTicket(new LottoNumbers(numbers)));
        LottoGame game = new LottoGame(tickets);
        game.generateGameResult(new WinnerTicket("4, 5, 6, 7, 8, 9"));
        assertThat(game.getScore().get(3)).isEqualTo(1);
    }

    @Test
    void 지난주_당첨_번호_콤마_뒤_공백() {
        WinnerTicket winnerTicket = new WinnerTicket("1, 2, 3, 4, 5, 6");
        assertNotNull(winnerTicket);
    }

    @Test
    void 지난주_당첨_번호_중복_입력() {
        assertThatThrownBy(() -> new WinnerTicket("1,2,3,4,6,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 지난주_당첨_번호_숫자_범위_초과() {
        LottoGame game = new LottoGame(14000);
        assertThatThrownBy(() -> new WinnerTicket("-1,2,3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
