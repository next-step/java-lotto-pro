package lotto;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
    void 번호_3개_일치() {
        List<LottoTicket> tickets = new ArrayList<>();
        List<LottoNumber> numbers = Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3)
                , new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
        tickets.add(new LottoTicket(new LottoNumbers(numbers)));
        LottoGame game = new LottoGame(tickets);
        game.generateGameResult(new WinnerTicket("4,5,6,7,8,9"));
        assertThat(game.getScore().get(3)).isEqualTo(1);
    }

    @Test
    void 번호_3개_일치_2건() {
        List<LottoTicket> tickets = new ArrayList<>();

        List<LottoNumber> testLottoNumbers1 = Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3)
                , new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
        tickets.add(new LottoTicket(new LottoNumbers(testLottoNumbers1)));

        List<LottoNumber> testLottoNumbers2 = Arrays.asList(new LottoNumber(1), new LottoNumber(10), new LottoNumber(11)
                , new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
        tickets.add(new LottoTicket(new LottoNumbers(testLottoNumbers2)));

        List<LottoNumber> testLottoNumbers3 = Arrays.asList(new LottoNumber(1), new LottoNumber(12), new LottoNumber(13)
                , new LottoNumber(14), new LottoNumber(5), new LottoNumber(6));
        tickets.add(new LottoTicket(new LottoNumbers(testLottoNumbers3)));

        LottoGame game = new LottoGame(tickets);
        game.generateGameResult(new WinnerTicket("4,5,6,7,8,9"));
        assertThat(game.getScore().get(3)).isEqualTo(2);
    }

    @Test
    void 번호_4개_일치() {
        List<LottoTicket> tickets = new ArrayList<>();
        List<LottoNumber> numbers = Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3)
                , new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
        tickets.add(new LottoTicket(new LottoNumbers(numbers)));

        LottoGame game = new LottoGame(tickets);
        game.generateGameResult(new WinnerTicket("1,2,3,4,8,9"));
        assertThat(game.getScore().get(4)).isEqualTo(1);
    }

    @Test
    void 번호_4개_일치_2건() {
        List<LottoTicket> tickets = new ArrayList<>();

        List<LottoNumber> testLottoNumber1 = Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3)
                , new LottoNumber(4), new LottoNumber(15), new LottoNumber(16));
        tickets.add(new LottoTicket(new LottoNumbers(testLottoNumber1)));

        List<LottoNumber> testLottoNumber2 = Arrays.asList(new LottoNumber(11), new LottoNumber(12), new LottoNumber(3)
                , new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
        tickets.add(new LottoTicket(new LottoNumbers(testLottoNumber2)));

        List<LottoNumber> testLottoNumber3 = Arrays.asList(new LottoNumber(21), new LottoNumber(22), new LottoNumber(23)
                , new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
        tickets.add(new LottoTicket(new LottoNumbers(testLottoNumber3)));

        LottoGame game = new LottoGame(tickets);
        game.generateGameResult(new WinnerTicket("1,2,3,4,5,6"));
        assertThat(game.getScore().get(4)).isEqualTo(2);
    }

    @Test
    void 번호_5개_일치() {
        List<LottoTicket> tickets = new ArrayList<>();
        List<LottoNumber> numbers = Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3)
                , new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
        tickets.add(new LottoTicket(new LottoNumbers(numbers)));

        LottoGame game = new LottoGame(tickets);
        game.generateGameResult(new WinnerTicket("1,2,3,4,5,9"));
        assertThat(game.getScore().get(5)).isEqualTo(1);
    }

    @Test
    void 번호_5개_일치_2건() {
        List<LottoTicket> tickets = new ArrayList<>();

        List<LottoNumber> testLottoNumber1 = Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3)
                , new LottoNumber(4), new LottoNumber(5), new LottoNumber(16));
        tickets.add(new LottoTicket(new LottoNumbers(testLottoNumber1)));

        List<LottoNumber> testLottoNumber2 = Arrays.asList(new LottoNumber(11), new LottoNumber(2), new LottoNumber(3)
                , new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
        tickets.add(new LottoTicket(new LottoNumbers(testLottoNumber2)));

        List<LottoNumber> testLottoNumber3 = Arrays.asList(new LottoNumber(21), new LottoNumber(32), new LottoNumber(3)
                , new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
        tickets.add(new LottoTicket(new LottoNumbers(testLottoNumber3)));

        LottoGame game = new LottoGame(tickets);
        game.generateGameResult(new WinnerTicket("1,2,3,4,5,6"));
        assertThat(game.getScore().get(5)).isEqualTo(2);
    }

    @Test
    void 번호_6개_일치() {
        List<LottoTicket> tickets = new ArrayList<>();
        List<LottoNumber> numbers = Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3)
                , new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
        tickets.add(new LottoTicket(new LottoNumbers(numbers)));

        LottoGame game = new LottoGame(tickets);
        game.generateGameResult(new WinnerTicket("1,2,3,4,5,6"));
        assertThat(game.getScore().get(6)).isEqualTo(1);
    }

    @Test
    void 번호_6개_일치_2건() {
        List<LottoTicket> tickets = new ArrayList<>();

        List<LottoNumber> testLottoNumbers1 = Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3)
                , new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));

        tickets.add(new LottoTicket(new LottoNumbers(testLottoNumbers1)));
        tickets.add(new LottoTicket(new LottoNumbers(testLottoNumbers1)));

        List<LottoNumber> testLottoNumbers2 = Arrays.asList(new LottoNumber(21), new LottoNumber(32), new LottoNumber(3)
                , new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
        tickets.add(new LottoTicket(new LottoNumbers(testLottoNumbers2)));

        LottoGame game = new LottoGame(tickets);
        game.generateGameResult(new WinnerTicket("1,2,3,4,5,6"));
        assertThat(game.getScore().get(6)).isEqualTo(2);
    }

    @Test
    void 총_수익률_5() {
        List<LottoTicket> tickets = new ArrayList<>();
        List<LottoNumber> numbers = Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3)
                , new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
        tickets.add(new LottoTicket(new LottoNumbers(numbers)));

        LottoGame game = new LottoGame(tickets);
        game.generateGameResult(new WinnerTicket("4,5,6,7,8,9"));
        assertThat(game.getEarningRate()).isEqualTo(5.00);
    }

    @Test
    void 총_수익률_1보다_작은_경우() {
        List<LottoTicket> tickets = new ArrayList<>();

        List<LottoNumber> testLottoNumbers1 = Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3)
                , new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
        tickets.add(new LottoTicket(new LottoNumbers(testLottoNumbers1)));

        List<LottoNumber> testLottoNumbers2 = Arrays.asList(new LottoNumber(11), new LottoNumber(12), new LottoNumber(13)
                , new LottoNumber(14), new LottoNumber(15), new LottoNumber(16));

        tickets.add(new LottoTicket(new LottoNumbers(testLottoNumbers2)));
        tickets.add(new LottoTicket(new LottoNumbers(testLottoNumbers2)));
        tickets.add(new LottoTicket(new LottoNumbers(testLottoNumbers2)));
        tickets.add(new LottoTicket(new LottoNumbers(testLottoNumbers2)));
        tickets.add(new LottoTicket(new LottoNumbers(testLottoNumbers2)));
        tickets.add(new LottoTicket(new LottoNumbers(testLottoNumbers2)));
        tickets.add(new LottoTicket(new LottoNumbers(testLottoNumbers2)));
        tickets.add(new LottoTicket(new LottoNumbers(testLottoNumbers2)));
        tickets.add(new LottoTicket(new LottoNumbers(testLottoNumbers2)));

        LottoGame game = new LottoGame(tickets);
        game.generateGameResult(new WinnerTicket("4,5,6,7,8,9"));
        assertThat(game.getEarningRate()).isEqualTo(0.50);
    }
}
