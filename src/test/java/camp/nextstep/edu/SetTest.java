package camp.nextstep.edu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class SetTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("size 메소드를 이용하여 크기를 구하기")
    @Test
    void sizeTest() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("Set 의 contains 메소드를 이용하여 값을 확인")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void containsTest(final int index) {
        assertThat(numbers.contains(index)).isTrue();
    }

    @DisplayName("contains 메소드를 이용하여 내부 값인 경우는 true, 아니면 false 를 확인")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    public void testIsContain_ShouldReturnTrue_NoContain_ShouldReturnFalse(final int input, final boolean expectedResult) {
        assertThat(numbers.contains(input)).isEqualTo(expectedResult);
    }
}
