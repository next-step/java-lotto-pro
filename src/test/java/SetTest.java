import org.junit.jupiter.api.BeforeEach;
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

    @Test
    void 크기를_확인한다() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest(name = "{0} 값이 존재한다")
    @ValueSource(ints = {1,2,3})
    void 값의_존재여부를_확인한다(int value) {
        assertThat(numbers.contains(value)).isTrue();
    }

    @ParameterizedTest(name = "{0} 값 존재 여부 : {1}")
    @CsvSource(value = {"1:true","2:true","3:true","4:false","5:false"}, delimiter = ':')
    void 값의_존재_미존재_여부를_확인한다(int value, boolean expected) {
        assertThat(numbers.contains(value)).isEqualTo(expected);
    }
}
