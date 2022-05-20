package lotto.service;

import lotto.model.Money;
import lotto.model.Result;
import lotto.model.Summary;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LotterySummaryTest {
    @Test
    void 로또_결과() {
        Result result1 = new Result(3, 1);
        Result result2 = new Result(4, 1);

        List<Result> results = Arrays.asList(result1, result2);

        assertThat(new Summary(results).sum()).isEqualTo(55000);
    }

    @Test
    void 로또_수익률() {
        Result result = new Result(3, 1);

        List<Result> results = Collections.singletonList(result);

        assertThat(YieldCalculator.earningsRate(new Summary(results), new Money(10000))).isEqualTo(0.50);
    }
}