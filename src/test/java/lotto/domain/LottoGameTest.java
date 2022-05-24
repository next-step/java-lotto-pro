package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoGameTest {

    private LottoNumber bonusNumber = new LottoNumber(45);

    @Test
    void 구입금액이_음수인_경우() {
        NumberGenerator numberGenerator = new LottoNumberGenerator();
        assertThatThrownBy(() -> new LottoGame(-1, numberGenerator))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void 구매장수_계산() {
        LottoGame game = new LottoGame(9999, new LottoNumberGenerator());
        assertEquals(9, game.getTicketCount());
    }

    @Test
    void 번호_3개_일치() {
        List<LottoTicket> tickets = new ArrayList<>();
        tickets.add(new LottoTicket(new LottoNumbers(Arrays.asList(1,2,3,4,5,6))));
        LottoGame game = new LottoGame(tickets);
        game.generateGameResult(new WinnerTicket("4,5,6,7,8,9", bonusNumber));
        assertThat(game.getScore()).containsEntry(Rank.FIFTH, 1);
    }

    @Test
    void 번호_3개_일치_2건() {
        List<LottoTicket> tickets = new ArrayList<>();

        tickets.add(new LottoTicket(new LottoNumbers(Arrays.asList(1,2,3,4,5,6))));
        tickets.add(new LottoTicket(new LottoNumbers(Arrays.asList(1,2,3,4,5,6))));
        tickets.add(new LottoTicket(new LottoNumbers(Arrays.asList(1,12,13,14,5,6))));

        LottoGame game = new LottoGame(tickets);
        game.generateGameResult(new WinnerTicket("4,5,6,7,8,9", bonusNumber));
        assertThat(game.getScore()).containsEntry(Rank.FIFTH, 2);
    }

    @Test
    void 번호_4개_일치() {
        List<LottoTicket> tickets = new ArrayList<>();
        tickets.add(new LottoTicket(new LottoNumbers(Arrays.asList(1,2,3,4,5,6))));

        LottoGame game = new LottoGame(tickets);
        game.generateGameResult(new WinnerTicket("1,2,3,4,8,9", bonusNumber));
        assertThat(game.getScore()).containsEntry(Rank.FOURTH, 1);
    }

    @Test
    void 번호_4개_일치_2건() {
        List<LottoTicket> tickets = new ArrayList<>();

        tickets.add(new LottoTicket(new LottoNumbers(Arrays.asList(1,2,3,4,15,16))));
        tickets.add(new LottoTicket(new LottoNumbers(Arrays.asList(11,12,3,4,5,6))));
        tickets.add(new LottoTicket(new LottoNumbers(Arrays.asList(21,22,23,4,5,6))));

        LottoGame game = new LottoGame(tickets);
        game.generateGameResult(new WinnerTicket("1,2,3,4,5,6", bonusNumber));
        assertThat(game.getScore()).containsEntry(Rank.FOURTH, 2);
    }

    @Test
    void 번호_5개_일치() {
        List<LottoTicket> tickets = new ArrayList<>();

        tickets.add(new LottoTicket(new LottoNumbers(Arrays.asList(1,2,3,4,5,6))));

        LottoGame game = new LottoGame(tickets);
        game.generateGameResult(new WinnerTicket("1,2,3,4,5,9", bonusNumber));
        assertThat(game.getScore()).containsEntry(Rank.THIRD, 1);
    }

    @Test
    void 번호_5개_일치_2건() {
        List<LottoTicket> tickets = new ArrayList<>();

        tickets.add(new LottoTicket(new LottoNumbers(Arrays.asList(1,2,3,4,5,16))));
        tickets.add(new LottoTicket(new LottoNumbers(Arrays.asList(11,2,3,4,5,6))));
        tickets.add(new LottoTicket(new LottoNumbers(Arrays.asList(21,32,3,4,5,6))));

        LottoGame game = new LottoGame(tickets);
        game.generateGameResult(new WinnerTicket("1,2,3,4,5,6", bonusNumber));
        assertThat(game.getScore()).containsEntry(Rank.THIRD, 2);
    }

    @Test
    void 번호_6개_일치() {
        List<LottoTicket> tickets = new ArrayList<>();

        tickets.add(new LottoTicket(new LottoNumbers(Arrays.asList(1,2,3,4,5,6))));

        LottoGame game = new LottoGame(tickets);
        game.generateGameResult(new WinnerTicket("1,2,3,4,5,6", bonusNumber));
        assertThat(game.getScore()).containsEntry(Rank.FIRST, 1);
    }

    @Test
    void 번호_6개_일치_2건() {
        List<LottoTicket> tickets = new ArrayList<>();

        tickets.add(new LottoTicket(new LottoNumbers(Arrays.asList(1,2,3,4,5,6))));
        tickets.add(new LottoTicket(new LottoNumbers(Arrays.asList(1,2,3,4,5,6))));
        tickets.add(new LottoTicket(new LottoNumbers(Arrays.asList(21,32,3,4,5,6))));

        LottoGame game = new LottoGame(tickets);
        game.generateGameResult(new WinnerTicket("1,2,3,4,5,6", bonusNumber));
        assertThat(game.getScore()).containsEntry(Rank.FIRST, 2);
    }

    @Test
    void 총_수익률_5() {
        List<LottoTicket> tickets = new ArrayList<>();
        tickets.add(new LottoTicket(new LottoNumbers(Arrays.asList(1,2,3,4,5,6))));

        LottoGame game = new LottoGame(tickets);
        game.generateGameResult(new WinnerTicket("4,5,6,7,8,9", bonusNumber));
        assertThat(game.getEarningRate()).isEqualTo(5.00);
    }

    @Test
    void 총_수익률_1보다_작은_경우() {
        List<LottoTicket> tickets = new ArrayList<>();

        tickets.add(new LottoTicket(new LottoNumbers(Arrays.asList(1,2,3,4,5,6))));

        List<Integer> failTicketNumber = Arrays.asList(11,12,13,14,15,16);
        tickets.add(new LottoTicket(new LottoNumbers(failTicketNumber)));
        tickets.add(new LottoTicket(new LottoNumbers(failTicketNumber)));
        tickets.add(new LottoTicket(new LottoNumbers(failTicketNumber)));
        tickets.add(new LottoTicket(new LottoNumbers(failTicketNumber)));
        tickets.add(new LottoTicket(new LottoNumbers(failTicketNumber)));
        tickets.add(new LottoTicket(new LottoNumbers(failTicketNumber)));
        tickets.add(new LottoTicket(new LottoNumbers(failTicketNumber)));
        tickets.add(new LottoTicket(new LottoNumbers(failTicketNumber)));
        tickets.add(new LottoTicket(new LottoNumbers(failTicketNumber)));

        LottoGame game = new LottoGame(tickets);
        game.generateGameResult(new WinnerTicket("4,5,6,7,8,9", bonusNumber));
        assertThat(game.getEarningRate()).isEqualTo(0.50);
    }

    @Test
    void 로또2등_번호5개일치_보너스볼일치() {
        List<LottoTicket> tickets = new ArrayList<>();
        List<Integer> ticketNumber = Arrays.asList(1,2,3,4,5,6);
        tickets.add(new LottoTicket(new LottoNumbers(ticketNumber)));

        WinnerTicket winnerTicket = new WinnerTicket("1,2,3,4,5,10", bonusNumber);
        LottoGame game = new LottoGame(tickets);
        game.generateGameResult(winnerTicket);
        assertThat(game.getScore()).containsEntry(Rank.THIRD, 1);
    }
}
