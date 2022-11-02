package lotto.domain;

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

        Map<Rank, Integer> statistics = lottoResult.statistics(tickets, LottoNumber.get(7));
        assertThat(statistics.get(Rank.FIRST)).isEqualTo(1);
    }

    @DisplayName("수익률을 구할 수 있다")
    @Test
    void return_rate_test() {
        LottoTicket winningTicket = new ManualLottoGenerator(Arrays.asList(1, 2, 3, 4, 5, 6)).create();
        LottoTicket myTicket = new ManualLottoGenerator(Arrays.asList(1, 2, 3, 4, 5, 6)).create();
        LottoResult result = new LottoResult(winningTicket);
        result.statistics(Arrays.asList(myTicket), LottoNumber.get(7));
        Money spendingMoney = new Money(1_000L);

        double expect = (double) Rank.FIRST.getMoneyValue() / spendingMoney.value();
        assertThat(result.returnRate(spendingMoney)).isEqualTo(expect);
    }
}
