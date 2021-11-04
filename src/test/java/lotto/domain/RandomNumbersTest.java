package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class RandomNumbersTest {

    @Test
    void 랜덤한_6자리_숫자를_생성한다() {
        RandomNumbers randomNumbers = new RandomNumbers(new FakeNumber());
        List<Integer> randoms = randomNumbers.random();
        assertAll(
            () -> assertThat(randoms.size()).isEqualTo(6),
            () -> assertThat(randoms).contains(1, 2, 3, 4, 5, 6)
        );
    }
}