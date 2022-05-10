package teststudy;

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

    @Test
    @DisplayName("Set의 size() 메소드를 활용해 Set의 크기를 확인하는 학습테스트")
    void setSizeTest() {
        final int setSize = 3;
        assertThat(numbers.size()).isEqualTo(setSize);
    }

    @Test
    @DisplayName("Set에 contain을 이용 하여 1, 2, 3의 값이 존재하는지를 확인하는 테스트")
    void contains() {
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }

    @DisplayName("ParameterizedTest를 이용하여 중복 코드 제거")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void contains(int number) {
        assertThat(numbers.contains(number)).isTrue();
    }

    @DisplayName("ParameterizedTest, CsvSource를 이용하여 테스트에 필요한 입력값과 기대값을 여러개 인자로 넘길 수 있다.")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void containsTrueFalse(String input, String expected) {
        Integer number = convertStringToInteger(input);
        Boolean result = convertStringToBoolean(expected);
        assertWithExpectedAndNumber(number, result);
    }

    private void assertWithExpectedAndNumber(Integer number, Boolean expected) {
        assertThat(numbers.contains(number)).isEqualTo(expected);
    }

    private Boolean convertStringToBoolean(String expected) {
        return Boolean.valueOf(expected);
    }

    private Integer convertStringToInteger(String input) {
        return Integer.valueOf(input);
    }
}
