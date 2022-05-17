import lotto.domain.LottoTicket;
import lotto.domain.Rank;
import lotto.domain.TicketCheckResult;
import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {

    @Test
    void 생성() {
        LottoTicket lottoTicket = new LottoTicket(Arrays.asList(
                Arrays.asList(1,2,3,4,5,6),
                Arrays.asList(7,8,9,10,11,12),
                Arrays.asList(13,14,15,16,17,18)
        ));
        assertThat(lottoTicket.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @EnumSource(value = Rank.class, names = {"MISS"})
    void 당첨_확인_1(Rank rank) {
        LottoTicket lottoTicket = new LottoTicket(Arrays.asList(
                Arrays.asList(10, 11, 12, 13, 14, 15),
                Arrays.asList(1, 11, 12, 13, 14, 15),
                Arrays.asList(10, 11, 12, 4, 14, 15),
                Arrays.asList(1, 2, 12, 13, 14, 15),
                Arrays.asList(10, 2, 12, 13, 5, 15)
        ));

        TicketCheckResult result = lottoTicket.check(new WinningNumbers("1,2,3,4,5,6"));

        assertThat(result.getCount(rank)).isEqualTo(5);
    }

    @ParameterizedTest
    @EnumSource(value = Rank.class, names = {"FIFTH", "FOURTH", "THIRD"})
    void 당첨_확인_2(Rank rank) {
        LottoTicket lottoTicket = new LottoTicket(Arrays.asList(
                Arrays.asList(1, 2, 3, 13, 14, 15),
                Arrays.asList(1, 2, 12, 13, 5, 15),
                Arrays.asList(10, 2, 3, 13, 5, 6),
                Arrays.asList(10, 2, 3, 4, 14, 6),
                Arrays.asList(10, 2, 3, 4, 5, 6),
                Arrays.asList(1, 11, 3, 4, 5, 6)
        ));

        TicketCheckResult result = lottoTicket.check(new WinningNumbers("1,2,3,4,5,6"));

        assertThat(result.getCount(rank)).isEqualTo(2);
    }

    @ParameterizedTest
    @EnumSource(value = Rank.class, names = {"FIRST"})
    void 당첨_확인_3(Rank rank) {
        LottoTicket lottoTicket = new LottoTicket(Arrays.asList(Arrays.asList(1, 2, 3, 4, 5, 6)));

        TicketCheckResult result = lottoTicket.check(new WinningNumbers("1,2,3,4,5,6"));

        assertThat(result.getCount(rank)).isEqualTo(1);
    }
}
