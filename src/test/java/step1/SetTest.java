package step1;

import static org.assertj.core.api.Assertions.*;

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
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    //요구사항 1
    @DisplayName("Set의 size() 메소드를 활용해 Set의 크기 확인")
    @Test
    void size() {
        int result = numbers.size();

        assertThat(result).isEqualTo(3);
    }

    //요구사항 2
    @ParameterizedTest(name = "Set의 contains() 메소드를 활용해 {arguments}의 값이 존재하는지를 확인")
    @ValueSource(ints = {1, 2, 3})
    void contains_1(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    //요구사항 3
    @ParameterizedTest(name = "Set의 contains() 메소드를 활용해 값이 존재하는지를 확인 ({0} : {1})")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void contains_2(int input, boolean expected) {
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }
}