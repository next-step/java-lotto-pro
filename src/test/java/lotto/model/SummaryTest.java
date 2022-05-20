package lotto.model;

import lotto.model.Result;
import lotto.model.Summary;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SummaryTest {
    @Test
    void 로또_수익_금액_합계() {
        Result result1 = new Result(3, 1);
        Result result2 = new Result(4, 2);
        Result result3 = new Result(5, 3);
        Result result4 = new Result(6, 1);
        List<Result> results = Arrays.asList(result1, result2, result3, result4);

        Summary summary = new Summary(results);

        assertThat(summary.sum()).isEqualTo(2004605000);
    }

    @Test
    void 로또_수익_금액_없음() {
        assertThat(new Summary(new LinkedList<>()).sum()).isEqualTo(0);
    }
}
