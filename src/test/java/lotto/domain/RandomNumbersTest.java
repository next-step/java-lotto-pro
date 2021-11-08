package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumbersTest {

    @Test
    void 랜덤한_6자리_숫자를_생성한다() {
        RandomNumbers randomNumbers = new RandomNumbers();
        List<Integer> randoms = randomNumbers.random();
        assertThat(randoms.size()).isEqualTo(6);
    }

    @Test
    void 리스트_앞_6자리를_가져온다() {
        List<Integer> collect = IntStream.range(1, 40)
                .limit(6)
                .mapToObj(Integer::new)
                .collect(Collectors.toList());
        assertThat(collect.size()).isEqualTo(6);
        assertThat(collect).contains(1,2,3,4,5,6);
    }
}