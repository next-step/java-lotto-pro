package level1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class CollectionTest {
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
    void Set_의_size_메서드를_활용하여_해당_컬렉션의_크기를_테스트한다() {
        assertThat(numbers.size()).isEqualTo(3);
        assertThat(numbers).containsExactly(1, 2, 3);
    }

    @ParameterizedTest(name = "JUnit 의 ParameterizedTest 를 활용하여 Set 의 contains 의 중복을 제거한 테스트를 진행한다. 찾는 값: {0}")
    @ValueSource(ints = {1, 2, 3})
    void containTest(int number) {
        assertThat(numbers).contains(number);
    }

    @ParameterizedTest(name = "값에 따라 결과 값이 다른 경우 테스트한다. 찾는 값: {0}")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void dynamicContainTest(int number, boolean expect) {
        boolean isContain = numbers.contains(number);

        assertThat(isContain).isEqualTo(expect);
    }
}
