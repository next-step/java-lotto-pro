import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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
    @DisplayName("요구사항1 - Set 크기 확인 테스트")
    public void testSetSize() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest(name = "{displayName} - Element: [{0}], Expected: [true]")
    @ValueSource(ints = {1,2,3})
    @DisplayName("요구사항2 - 요소 존재 확인 테스트")
    public void testContainsElement(int element) {
        assertThat(numbers).contains(element);
    }

    @ParameterizedTest(name = "{displayName} - Element: [{0}], Expected: [{1}]")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    @DisplayName("요구사항3 - 요소 존재 여부 테스트")
    public void testIsContainsElement(int element, boolean expected) {
        assertThat(numbers.contains(element)).isEqualTo(expected);
    }
}
