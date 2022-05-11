package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

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

    @Test
    @DisplayName("Set의 size() 메소드를 활용해 Set의 크기를 확인")
    void sizeTest(){
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest(name="Set에 {0} 값이 존재하는지 확인")
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("Set의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인")
    public void containsTest(int number) {
        assertThat(numbers.contains(number)).isTrue();
    }

    @ParameterizedTest(name="Set에 {0} 값이 존재하는지 확인 : {1}")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    @DisplayName("Set의 contains() 메소드를 활용해 1, 2, 3, 4, 5의 값이 존재하는지를 확인")
    void containsTestWithDifferentResult(int number, boolean result) {
        assertThat(numbers.contains(number)).isEqualTo(result);
    }
}
