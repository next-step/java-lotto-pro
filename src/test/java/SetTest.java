import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

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

    @DisplayName("Set의 size 메서드로 크기 확인하기 테스트")
    @Test
    public void setSizeTest() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("contains 메서드를 통해 값이 존재하는지 확인 및 @ValueSource를 활용하여 중복된 코드 제거 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void isExistInSetTest(int number) {
        assertThat(numbers.contains(number)).isTrue();
    }

    @DisplayName("입력값에 따라 결과값이 다른경우 @CsvSource을 활용하는 테스트")
    @ParameterizedTest
    @CsvSource({"1,true", "2,true", "3,true", "4,false", "5,false"})
    public void isExistOrNotInSetTest(int number, boolean isExist) {
        assertThat(numbers.contains(number)).isEqualTo(isExist);
    }
}
