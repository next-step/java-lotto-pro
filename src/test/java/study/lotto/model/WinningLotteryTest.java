package study.lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinningLotteryTest {
    WinningLottery winningLottery;

    @BeforeEach
    void setUp() {
        final List<Integer> winningLottoNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
        final LottoNumber bonusNumber = LottoNumber.valueOf(7);
        winningLottery = WinningLottery.valueOf(winningLottoNumber, bonusNumber);
    }

    @Test
    void 당첨_로또복권_와_당첨번뭉치호_와_비교하여_당첨등수_를_확인할_수_있다() {
        final TicketLotteryBundle ticketLotteryBundle = TicketLotteryBundle.valueOf(Arrays.asList(
                new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 7)),
                new HashSet<>(Arrays.asList(1, 2, 3, 4, 22, 33))
        ), TicketLotteryType.AUTO);

        final List<Rank> ranks = winningLottery.match(ticketLotteryBundle);

        assertThat(ranks).contains(Rank.FIRST);
        assertThat(ranks).contains(Rank.SECOND);
        assertThat(ranks).contains(Rank.FOURTH);
        assertThat(ranks).containsAll(Arrays.asList(Rank.FIRST, Rank.SECOND, Rank.FOURTH));
    }
}