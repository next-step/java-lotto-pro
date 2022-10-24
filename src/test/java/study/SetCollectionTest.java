package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SetCollectionTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("set의 크기(size) 확인")
    @Test
    public void size_test() {
        // then
        assertThat(numbers).hasSize(3);
    }

    @DisplayName("ParameterizedTest 활용하여 Contains 중복코드 제거")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void isContains_ShouldReturnTrueForNumbersHad(int input) {
        assertTrue(numbers.contains(input));
    }

    @DisplayName("CsvSource 활용하여 입력값에 따른 결과값 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void csvSourceTest(int input, boolean expected) {
        boolean isContains = numbers.contains(input);
        assertThat(isContains).isEqualTo(expected);
    }
}
