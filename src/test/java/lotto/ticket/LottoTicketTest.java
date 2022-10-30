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
        int size = lottoTicket.size();
        assertThat(size).isEqualTo(SLOT_SIZE);
    }

    @Test
    void 입력_값을_통한_로또번호_6자리_생성(){
        String input = "1,2,3,4,5,6";
        LottoTicket lottoTicket = new LottoTicket(input);
        assertThat(lottoTicket.size()).isEqualTo(6);
    }

    @Test
    void 두_개의_로또가_일치하는지_테스트(){
        LottoTicket lottoTicket = new LottoTicket("1,2,3,4,5,6");
        LottoTicket winnerLottoTicket = new LottoTicket("1,2,3,4,5,6");
        int matchCount = lottoTicket.match(winnerLottoTicket);
        assertThat(matchCount).isEqualTo(6);
    }

    @Test
    void 구매한_로또_한개와_당첨번호_6개_모두_일치하면_일치한_갯수_6을_반환한다(){
        LottoTicket userLotto = new LottoTicket("1,2,3,4,5,6");
        WinnerLottoTicket winnerLotto = new WinnerLottoTicket(
                new LottoTicket("1,2,3,4,5,6"),
                7);
        int match = userLotto.match(winnerLotto.getLotto());
        assertThat(match).isEqualTo(Rank.FIRST.getCountOfMatch());
    }

    @Test
    void 구매한_로또_한개와_당첨번호_5개_치하면_일치한_갯수_5를_반환한다(){
        LottoTicket userLotto = new LottoTicket("1,2,3,4,5,45");
        WinnerLottoTicket winnerLotto = new WinnerLottoTicket(
                new LottoTicket("1,2,3,4,5,7"),
                45);
        int match = userLotto.match(winnerLotto.getLotto());
        assertThat(match).isEqualTo(Rank.SECOND.getCountOfMatch());
    }

    @Test
    void 구매한_로또_한개와_당첨번호_4개가_일치하면_일치한_갯수_4를_반환한다(){
        LottoTicket userLotto = new LottoTicket("1,2,3,4,5,6");
        WinnerLottoTicket winnerLotto = new WinnerLottoTicket(
                new LottoTicket("1,2,3,4,10,11"),
                45);
        int match = userLotto.match(winnerLotto.getLotto());
        assertThat(match).isEqualTo(Rank.FOURTH.getCountOfMatch());
    }

    @Test
    void 구매한_로또_한개와_당첨번호_3개가_일치하면_일치한_갯수_3을_반환한다(){
        LottoTicket userLotto = new LottoTicket("1,2,3,4,5,6");
        WinnerLottoTicket winnerLotto = new WinnerLottoTicket(
                new LottoTicket("1,2,3,10,11,12"),
                45);
        int match = userLotto.match(winnerLotto.getLotto());
        assertThat(match).isEqualTo(Rank.FIFTH.getCountOfMatch());
    }

}