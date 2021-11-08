package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StatisticsTest {

    private Statistics statistics;

    @BeforeEach
    void setUp() {
        statistics = new Statistics();
    }

    @DisplayName("FIRST 1개 조회")
    @Test
    void getOne() {
        statistics.record(Ranking.FIRST);
        Integer result = statistics.getCount(Ranking.FIRST);
        assertThat(result).isEqualTo(1);
    }

    @DisplayName("FIRST 3개 조회")
    @Test
    void getThree() {
        statistics.record(Ranking.FIRST);
        statistics.record(Ranking.FIRST);
        statistics.record(Ranking.FIRST);
        Integer result = statistics.getCount(Ranking.FIRST);
        assertThat(result).isEqualTo(3);
    }

    @DisplayName("10,000원 넣어서 5,000원 당첨되면 수익률은 0.50 이다.")
    @Test
    void test() {
        Money inputMoney = new Money(10_000);
        statistics.record(Ranking.FOURTH);

        double rate = statistics.calculateEarningRate(inputMoney);

        assertThat(rate).isEqualTo(0.50);
    }

}
