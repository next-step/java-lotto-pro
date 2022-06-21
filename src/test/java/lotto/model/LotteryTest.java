package lotto.model;

import lotto.service.LotteryProducer;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThatCode;

class LotteryTest {
    @Test
    void createLottery() {
        assertThatCode(() -> new Lottery(LotteryProducer.issue())).doesNotThrowAnyException();
    }

    @Test
    void usePrimitive() {
        Set<Integer> numbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThatCode(() -> new Lottery(numbers)).doesNotThrowAnyException();
    }
}