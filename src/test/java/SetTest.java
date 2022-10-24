import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

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
    @DisplayName("size() 메소드를 활용한 Set 크기 테스트")
    void size() {
        assertThat(numbers).hasSize(3);
    }

    @Test
    @DisplayName("contains() 메소드를 활용해 1,2,3 의 값이 존재하는 지 테스트")
    void contains() {
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("ValueSource로 부터 값을 받아 contains() 메소트 ParameterizedTest")
    @ValueSource(ints = {1, 2, 3})
    void contains_with_Parameterized_from_ValueSource(int number) {
        assertThat(numbers.contains(number)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("CsvSource로 부터 값을 받아 contains() 메소트 ParameterizedTest")
    @CsvSource(value = {"1:true"
            , "2:true"
            , "3:true"
            , "4:false"
            , "5:false"
    }, delimiter = ':')
    void contains_with_Parameterized_from_CsvSource(int number, boolean expected) {
        assertThat(numbers.contains(number)).isEqualTo(expected);
    }
}
