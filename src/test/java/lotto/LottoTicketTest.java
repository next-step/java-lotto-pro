package lotto;

import lotto.domain.LottoGame;
import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.domain.Rank;
import lotto.domain.TicketCheckResult;
import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {

    @Test
    void 생성() {
        LottoTicket lottoTicket = new LottoTicket();
        lottoTicket.addGame(new LottoGame("1, 2, 3, 4, 5, 6"));
        lottoTicket.addGame(new LottoGame("7, 8, 9, 10, 11, 12"));
        lottoTicket.addGame(new LottoGame("13, 14, 15, 16, 17, 18"));

        assertThat(lottoTicket.size()).isEqualTo(3);
    }

    @Test
    void 생성_2() {
        LottoGame lottoGame1 = new LottoGame("1,2,3,4,5,6");
        LottoGame lottoGame2 = new LottoGame("7,8,9,10,11,12");
        List<LottoGame> lottoGames = Arrays.asList(lottoGame1, lottoGame2);

        LottoTicket lottoTicket1 = new LottoTicket();
        lottoTicket1.addAllGames(lottoGames);

        LottoTicket lottoTicket2 = new LottoTicket();
        lottoTicket2.addGame(lottoGame1);
        lottoTicket2.addGame(lottoGame2);

        assertThat(lottoTicket1).isEqualTo(lottoTicket2);
    }

    @ParameterizedTest
    @EnumSource(value = Rank.class, names = {"MISS"})
    void 당첨_확인_1(Rank rank) {
        LottoTicket lottoTicket = new LottoTicket();
        lottoTicket.addGame(new LottoGame(Arrays.asList(10, 11, 12, 13, 14, 15)));
        lottoTicket.addGame(new LottoGame(Arrays.asList(1, 11, 12, 13, 14, 15)));
        lottoTicket.addGame(new LottoGame(Arrays.asList(10, 11, 12, 4, 14, 15)));
        lottoTicket.addGame(new LottoGame(Arrays.asList(1, 2, 12, 13, 14, 15)));
        lottoTicket.addGame(new LottoGame(Arrays.asList(10, 2, 12, 13, 5, 15)));

        TicketCheckResult result = lottoTicket.check(new WinningNumbers("1,2,3,4,5,6"), new LottoNumber(7));

        assertThat(result.getCount(rank)).isEqualTo(5);
    }

    @ParameterizedTest
    @EnumSource(value = Rank.class, names = {"FIFTH", "FOURTH", "THIRD"})
    void 당첨_확인_2(Rank rank) {
        LottoTicket lottoTicket = new LottoTicket();
        lottoTicket.addGame(new LottoGame(Arrays.asList(1, 2, 3, 13, 14, 15)));
        lottoTicket.addGame(new LottoGame(Arrays.asList(1, 2, 12, 13, 5, 15)));
        lottoTicket.addGame(new LottoGame(Arrays.asList(10, 2, 3, 13, 5, 6)));
        lottoTicket.addGame(new LottoGame(Arrays.asList(10, 2, 3, 4, 14, 6)));
        lottoTicket.addGame(new LottoGame(Arrays.asList(10, 2, 3, 4, 5, 6)));
        lottoTicket.addGame(new LottoGame(Arrays.asList(1, 11, 3, 4, 5, 6)));

        TicketCheckResult result = lottoTicket.check(new WinningNumbers("1,2,3,4,5,6"), new LottoNumber(7));

        assertThat(result.getCount(rank)).isEqualTo(2);
    }

    @ParameterizedTest
    @EnumSource(value = Rank.class, names = {"FIRST"})
    void 당첨_확인_3(Rank rank) {
        LottoTicket lottoTicket = new LottoTicket();
        lottoTicket.addGame(new LottoGame(Arrays.asList(1, 2, 3, 4, 5, 6)));

        TicketCheckResult result = lottoTicket.check(new WinningNumbers("1,2,3,4,5,6"), new LottoNumber(7));

        assertThat(result.getCount(rank)).isEqualTo(1);
    }
}
