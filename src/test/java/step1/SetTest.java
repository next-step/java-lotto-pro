package step1;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("Set.size() 테스트")
    void setSizeTest() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3"})
    @DisplayName("Set.contains() 를 활용하여 setUp() 에서 생성된 numbers 가 1,2,3 을 모두 포함하는지 테스트")
    void containsTest(Integer input) {
        assertTrue(numbers.contains(input));
    }

    @ParameterizedTest
    @CsvSource(value = {
        "1:true", "2:true", "3:true", "4:false", "5:false"
    }, delimiter = ':')
    @DisplayName("CsvSource 를 활용하여 numbers.contains() 의 포함, 미포함 케이스 한번에 테스트")
    void containsTrueOrFailTest(Integer input, boolean expected) {
        assertEquals(numbers.contains(input), expected);
    }

}
