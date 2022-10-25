package study;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class SetTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @ParameterizedTest
    @DisplayName("1,2,3 은 true 4,5는 false")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void contains_true_false(int data, boolean expected) {
        assertThat(numbers.contains(data)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void contains(int data) {
        assertThat(numbers.contains(data)).isTrue();
    }

    @Test
    void size() {
        assertThat(numbers).hasSize(3);
    }
}
