package lotto.domain;

import lotto.domain.dto.StatisticDto;
import lotto.fixture.LottoTicketFixture;
import lotto.util.ManualLottoGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoCommitteeTest {
    @DisplayName("통계를 구하면 StatisticDto가 반환된다")
    @Test
    void statistics_test() {
        LottoTicket winningTicket = new ManualLottoGenerator(Arrays.asList(1, 2, 3, 4, 5, 6)).create();
        LottoCommittee committee = new LottoCommittee(winningTicket);
        List<LottoTicket> ticket = Arrays.asList(LottoTicketFixture.create());

        assertThat(committee.statistics(ticket)).isInstanceOf(StatisticDto.class);
    }

    @DisplayName("로또 협회는 수익률을 구할 수 있다")
    @Test
    void return_rate_test() {
        LottoTicket winningTicket = new ManualLottoGenerator(Arrays.asList(1, 2, 3, 4, 5, 6)).create();
        LottoCommittee committee = new LottoCommittee(winningTicket);
        Money spendingMoney = new Money(1_000L);
        Money totalReturnMoney = new Money(10_000L);

        assertThat(committee.returnRate(totalReturnMoney, spendingMoney)).isEqualTo(10.00);
    }
}
