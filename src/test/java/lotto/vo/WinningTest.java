package lotto.vo;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinningTest {
    @Test
    void 로또_수익_금액() {
        Result result1 = new Result(3, 1, 5000);
        Result result2 = new Result(4, 2, 50000);
        Result result3 = new Result(5, 3, 1500000);
        Result result4 = new Result(6, 1, 2000000000);
        List<Result> results = new LinkedList<>();
        results.add(result1);
        results.add(result2);
        results.add(result3);
        results.add(result4);
        Winning winning = new Winning(results);
        assertThat(winning.sum()).isEqualTo(2004605000);
        assertThat(new Winning(new LinkedList<>()).sum()).isEqualTo(0);
    }
}
