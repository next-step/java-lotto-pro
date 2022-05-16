package lotto;

import lotto.vo.Money;
import lotto.vo.Result;
import lotto.vo.Winning;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LotteryStatisticsTest {
    @Test
    void 로또_결과() {
        Result result1 = new Result(3, 5000, 1);
        Result result2 = new Result(4, 50000, 1);
        List<Result> results = new LinkedList<>();
        results.add(result1);
        results.add(result2);
        Winning winning = new Winning(results);
        assertThat(winning.sum()).isEqualTo(55000);
    }

    @Test
    void 로또_수익률() {
        Result result = new Result(3, 5000, 1);
        List<Result> results = new LinkedList<>();
        results.add(result);
        Winning winning = new Winning(results);
        Money money = new Money(10000);
        assertThat(LotteryStatistics.earningsRate(winning, money)).isEqualTo(0.50);
    }
}