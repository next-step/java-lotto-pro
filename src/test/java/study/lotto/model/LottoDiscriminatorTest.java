package study.lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoDiscriminatorTest {

    WinningLottery winningLottery;

    @BeforeEach
    void setUp() {
        final List<Integer> winningLottoNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
        final LottoNumber bonusNumber = LottoNumber.valueOf(7);
        winningLottery = WinningLottery.valueOf(winningLottoNumber, bonusNumber);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:2:3:4:5:6:FIRST", "7:2:3:4:5:6:SECOND", "7:8:3:4:5:6:FOURTH", "7:8:9:4:5:6:FIFTH", "10:8:9:4:5:6:FIFTH", "7:9:10:22:32:45:MISS"}, delimiterString = ":")
    void 당첨_로또복권_와_당첨번호_와_비교하여_당첨등수_를_확인할_수_있다(
            final int ticketLottoNumber1, final int ticketLottoNumber2, final int ticketLottoNumber3,
            final int ticketLottoNumber4, final int ticketLottoNumber5, final int ticketLottoNumber6,
            final Rank expectedRank) {

        final List<Integer> ticketLottoNumbers =
                Arrays.asList(ticketLottoNumber1, ticketLottoNumber2, ticketLottoNumber3, ticketLottoNumber4, ticketLottoNumber5, ticketLottoNumber6);

        final TicketLottery ticketLottery = TicketLottery.valueOf(ticketLottoNumbers, TicketLotteryType.AUTO);

        final Rank rank = LottoDiscriminator.referee(winningLottery, ticketLottery);

        assertThat(rank).isEqualTo(expectedRank);
    }
}
