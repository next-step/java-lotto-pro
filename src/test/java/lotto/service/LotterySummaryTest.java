package lotto.service;

import lotto.model.Number;
import lotto.model.*;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class LotterySummaryTest {
    @Test
    void createSummary() {
        // given
        Map<Rank, Integer> ranks = new LinkedHashMap<>();
        Arrays.stream(Rank.reverseValues())
              .forEach(rank -> {
                  ranks.put(rank, 0);
                  ranks.put(Rank.FIRST, 1);
                  ranks.remove(Rank.MISS);
              });

        Summary expected = new Summary(ranks);

        // when
        List<Number> numbers = new LinkedList<>();
        IntStream.rangeClosed(1, 6)
                 .forEach(num -> numbers.add(new Number(num)));
        Winning details = new Winning(new Lottery(numbers), new Number(7));
        Lotteries purchase = new Lotteries(Collections.singletonList(new Lottery(numbers)));
        Summary actual = LotterySummary.createDetails(details, purchase);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}