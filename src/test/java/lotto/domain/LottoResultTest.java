package lotto.domain;

import lotto.domain.enums.Rank;
import lotto.fixture.LottoTicketFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {
    @DisplayName("통계를 구할 수 있다")
    @Test
    void statistics_test() {
        LottoTicket winningTicket = new ManualLottoGenerator(Arrays.asList(1, 2, 3, 4, 5, 6)).create();
        LottoResult lottoResult = new LottoResult(winningTicket);
        List<LottoTicket> tickets = Arrays.asList(LottoTicketFixture.create());

        Map<Rank, Integer> statistics = lottoResult.statistics(tickets);
        assertThat(statistics.get(Rank.FIRST)).isEqualTo(1);
    }

    @DisplayName("로또 협회는 수익률을 구할 수 있다")
    @Test
    void return_rate_test() {
        LottoTicket winningTicket = new ManualLottoGenerator(Arrays.asList(1, 2, 3, 4, 5, 6)).create();
        LottoResult committee = new LottoResult(winningTicket);
        Money spendingMoney = new Money(1_000L);
        Money totalReturnMoney = new Money(10_000L);

        assertThat(committee.returnRate(totalReturnMoney, spendingMoney)).isEqualTo(10.00);
    }
}
