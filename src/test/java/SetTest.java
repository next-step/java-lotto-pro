import static org.assertj.core.api.Assertions.assertThat;

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

    @DisplayName("numbers 의 사이즈는 3이다.")
    @Test
    void setNumber() {
        assertThat(numbers.size()).isEqualTo(3);
    }


    @ParameterizedTest(name = "numbers 는 {0}을 가지고 있다.")
    @ValueSource(ints = {1, 2, 3})
    void setContains(int target) {
        assertThat(numbers.contains(target)).isTrue();
    }

    @ParameterizedTest(name = "number에 {0}을 contains()하면 {1}이다.")
    @CsvSource(value = {"0:false", "1:true", "2:true", "3:true", "4:false"}, delimiter = ':')
    void setContainsTrueFalse(int target, boolean expect) {
        assertThat(numbers.contains(target)).isEqualTo(expect);
    }
}
