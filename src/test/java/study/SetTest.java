package study;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

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

    // Test Case 구현
    @Test
    @DisplayName("Set 에서 중복 항목이 비포함 된 size 확인")
    void size() {
        assertThat(numbers).hasSize(3);
    }

    @ParameterizedTest
    @DisplayName("Set 내에 특정 값이 존재하는지 확인")
    @ValueSource(ints = {1, 2, 3})
    void contains(int value) {
        assertThat(numbers.contains(value)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("Set 내의 특정 값의 존재 여부가 정상적으로 도출되는지 확인")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void containsWithExpectedResult(int value, boolean hasValue) {
        assertThat(numbers.contains(value)).isEqualTo(hasValue);
    }

}
