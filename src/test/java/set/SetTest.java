package set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SetTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("Set size 테스트")
    @Test
    public void setSizeTest() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("Set contains 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:2:3"}, delimiter = ':')
    public void containsTest(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @DisplayName("Set contains 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:true","2:true","3:true", "4:false", "5:false"}, delimiter = ':')
    public void containsTrueOrFalseTest(int input, boolean flag) {
        assertThat(numbers.contains(input)).isEqualTo(flag);
    }
}
