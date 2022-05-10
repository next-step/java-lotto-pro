package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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

    @DisplayName("SET 사이즈 측정 테스트")
    @Test
    void SET_사이즈_측정_테스트() {
        // given
        int expected = 3;

        // then
        assertThat(numbers).hasSize(expected);
    }

    @DisplayName("SET 값 존재 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void SET_값_존재_테스트(int expected) {
        assertThat(numbers.contains(expected)).isTrue();
    }

    @DisplayName("SET 값 포함, 미포함 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void SET_값_포함_미포함_테스트(int given, boolean expected) {
        Assertions.assertThat(numbers.contains(given)).isEqualTo(expected);
    }
}
