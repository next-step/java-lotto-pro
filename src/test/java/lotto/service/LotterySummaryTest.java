package lotto.service;

import lotto.model.Number;
import lotto.model.*;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class LotterySummaryTest {
    @Test
    void 당첨_내역() {
        Map<Rank, Integer> ranks = new LinkedHashMap<>();
        for (Rank rank : Rank.reverseValues()) {
            ranks.put(rank, 0);
        }
        ranks.put(Rank.FIRST, 1);
        Summary expected = new Summary(ranks);

        List<Number> numbers = new LinkedList<>();
        IntStream.rangeClosed(1, 6)
                 .forEach(num -> numbers.add(new Number(num)));
        Winning details = new Winning(new Lottery(numbers), new Number(7));
        Lotteries purchase = new Lotteries(Collections.singletonList(new Lottery(numbers)));
        Summary actual = LotterySummary.createDetails(details, purchase);

        assertThat(actual).isEqualTo(expected);
    }
}