package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomUtilsTest {
    @Test
    @DisplayName("로또 숫자는 총 6개이다.")
    void size_test() {
        List<Integer> numbers = RandomUtils.generateNonDuplicateNumbers();
        assertThat(numbers).hasSize(6);
    }

    @Test
    @DisplayName("로또 숫자는 숫자 범위 1 ~ 45 사이의 수이다.")
    void range_test() {
        List<Integer> numbers = RandomUtils.generateNonDuplicateNumbers();
        assertAll(
                () -> assertThat(numbers.get(0)).isGreaterThan(0).isLessThan(46),
                () -> assertThat(numbers.get(1)).isGreaterThan(0).isLessThan(46),
                () -> assertThat(numbers.get(2)).isGreaterThan(0).isLessThan(46),
                () -> assertThat(numbers.get(3)).isGreaterThan(0).isLessThan(46),
                () -> assertThat(numbers.get(4)).isGreaterThan(0).isLessThan(46),
                () -> assertThat(numbers.get(5)).isGreaterThan(0).isLessThan(46)
        );
    }
}
