import java.util.HashSet;
import java.util.Set;
import org.assertj.core.api.Assertions;
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

    @Test
    @DisplayName("세트의 사이즈는 3이 되어야 한다.")
    void checkSetSize() {
        Assertions.assertThat(numbers).hasSize(3);
        numbers.add(1);
        Assertions.assertThat(numbers).hasSize(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    @DisplayName("세트는 주어진 1,2,3의 값을 모두 포함하고 있다. 중복 검증 하지 않는다.")
    void checkSetContainsNumbers(int number) {
        Assertions.assertThat(numbers).contains(number);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    @DisplayName("세트는 주어진 1,2,3을 포함하고, 4,5를 포함하지 않는다. 조건에 따라 결과값을 리턴한다")
    void checkSetContainsNumbersOrNot(int number, boolean result) {
        Assertions.assertThat(numbers.contains(number)).isEqualTo(result);
    }

}
