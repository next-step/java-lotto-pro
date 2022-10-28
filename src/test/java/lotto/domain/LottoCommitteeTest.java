package lotto.domain;

import lotto.domain.dto.StatisticDto;
import lotto.fixture.LottoTicketFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoCommitteeTest {
    @DisplayName("로또 협회는 통계를 구할 수 있다")
    @Test
    void statistics_test() {
        LottoCommittee committee = new LottoCommittee(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<LottoTicket> ticket = Arrays.asList(LottoTicketFixture.create());

        assertThat(committee.statistics(ticket)).isInstanceOf(StatisticDto.class);
    }

    @DisplayName("로또 협회는 수익률을 구할 수 있다")
    @Test
    void return_rate_test() {
        LottoCommittee committee = new LottoCommittee(Arrays.asList(1, 2, 3, 4, 5, 6));
        int spendingMoney = 1000;
        Long totalReturnMoney = 10000L;

        assertThat(committee.returnRate(totalReturnMoney, spendingMoney)).isEqualTo(10.00);
    }
}
