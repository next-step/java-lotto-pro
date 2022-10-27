import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    // Test Case

    @DisplayName("Set의 크기는 추가한 요소에서 중복을 제거한 개수를 반환한다.")
    @Test
    void size() {
        assertThat(numbers).hasSize(3);
    }

    @ParameterizedTest(name = "주어진 Set에 [{0}]을 요소로 포함하는가 = {1}.")
    @CsvSource({
            "1, true",
            "2, true",
            "3, true",
            "4, false",
            "5, false"
    })
    void contains(int element, boolean expectedContains) {
        assertThat(numbers.contains(element)).isEqualTo(expectedContains);
    }
}
