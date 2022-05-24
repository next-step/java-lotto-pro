package lotto.service;

import lotto.model.Money;
import lotto.model.Rank;
import lotto.model.Summary;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class YieldCalculatorTest {
    @Test
    void 소수점_세번째_자리_버림() {
        double expected = 0.35;

        Map<Rank, Integer> ranks = new LinkedHashMap<>();
        for (Rank rank : Rank.reverseValues()) {
            ranks.put(rank, 0);
        }
        ranks.put(Rank.FIFTH, 1);
        double actual = YieldCalculator.earningsRate(new Summary(ranks), new Money(14000));

        assertThat(actual).isEqualTo(expected);
    }
}