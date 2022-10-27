package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

class RandomNumberPickStrategyTest {

    @DisplayName("6개의 수를 뽑을 수 있다.")
    @RepeatedTest(10)
    void pickRandomNumber() {

        assertThat(new RandomNumberPickStrategy().pick().size()).isEqualTo(6);
    }

    @DisplayName("뽑은 수는 서로 다른 6개이다. ")
    @RepeatedTest(10)
    void unique_numbers() {

        Set<Integer> numbers = new HashSet<>(new RandomNumberPickStrategy().pick());
        assertThat(numbers.size()).isEqualTo(6);
    }
}
