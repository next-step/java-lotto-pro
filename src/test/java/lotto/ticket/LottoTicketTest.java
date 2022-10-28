package lotto.ticket;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Random;
import lotto.match.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LottoTicketTest {
    private final int SLOT_SIZE = 6;
    Random random = null;

    @BeforeEach
    void Setup(){
        random = new Random();
    }

    @Test
    void 중복없는_로또번호_6자리_생성(){
        LottoTicket lottoTicket = new LottoTicket();
        int size = lottoTicket.getNumbers().size();
        assertThat(size).isEqualTo(SLOT_SIZE);
    }

    @Test
    void 입력_값을_통한_로또번호_6자리_생성(){
        String input = "1,2,3,4,5,6";
        LottoTicket lottoTicket = new LottoTicket(input);
        assertThat(lottoTicket.getNumbers().size()).isEqualTo(6);
    }

    @Test
    void match(){
        LottoTicket lottoTicket = new LottoTicket("1,2,3,4,5,6");
        LottoTicket winnerLottoTicket = new LottoTicket("1,2,3,4,5,6");
        int matchCount = lottoTicket.match(winnerLottoTicket);
        assertThat(matchCount).isEqualTo(6);
    }

    @Test
    void 로또_6개_일치(){
        LottoTicket userLotto = new LottoTicket("1,2,3,4,5,6");
        WinnerLottoTicket winnerLotto = new WinnerLottoTicket(
                new LottoTicket("1,2,3,4,5,6"),
                7);
        int match = userLotto.match(winnerLotto.getLotto());
        assertThat(match).isEqualTo(Rank.FIRST.getCountOfMatch());
    }

    @Test
    void 로또_5개_일치(){
        LottoTicket userLotto = new LottoTicket("1,2,3,4,5,45");
        WinnerLottoTicket winnerLotto = new WinnerLottoTicket(
                new LottoTicket("1,2,3,4,5,7"),
                45);
        int match = userLotto.match(winnerLotto.getLotto());
        assertThat(match).isEqualTo(Rank.SECOND.getCountOfMatch());
    }

    @Test
    void 로또_4개_일치(){
        LottoTicket userLotto = new LottoTicket("1,2,3,4,5,6");
        WinnerLottoTicket winnerLotto = new WinnerLottoTicket(
                new LottoTicket("1,2,3,4,10,11"),
                45);
        int match = userLotto.match(winnerLotto.getLotto());
        assertThat(match).isEqualTo(Rank.FOURTH.getCountOfMatch());
    }

    @Test
    void 로또_3개_일치(){
        LottoTicket userLotto = new LottoTicket("1,2,3,4,5,6");
        WinnerLottoTicket winnerLotto = new WinnerLottoTicket(
                new LottoTicket("1,2,3,10,11,12"),
                45);
        int match = userLotto.match(winnerLotto.getLotto());
        assertThat(match).isEqualTo(Rank.FIFTH.getCountOfMatch());
    }

}
