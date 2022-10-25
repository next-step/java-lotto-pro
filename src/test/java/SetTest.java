import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


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
    @DisplayName("Set 사이즈 확인 테스트")
    void checkSetSizeTest() {
        assertThat(numbers).hasSize(3);
    }

    @ParameterizedTest
    @DisplayName("Set 값 확인 테스트")
    @ValueSource(ints = {1, 2, 3})
    void checkEachValOfSetTest(int num) {
        assertThat(numbers).contains(num);
    }

    @ParameterizedTest
    @DisplayName("Set에 특정 값이 포함되었는지 테스트")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void checkContainsSpecificValTest(int num, boolean flag) {
        assertThat(numbers.contains(num)).isEqualTo(flag);
    }
}
