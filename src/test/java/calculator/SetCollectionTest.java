package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Set Collection 에 대한 테스트")
class SetCollectionTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Nested
    @DisplayName("Set Collection Size 테스트")
    class SetCollectionSizeTest {

        @Test
        @DisplayName("Set Collection 의 Size 가 정상적으로 반환되어야 한다")
        void set_collection_size_test() {
            assertThat(numbers).hasSize(3);
        }
    }

    @Nested
    @DisplayName("Set Collection Contains 테스트")
    class SetContainsTest {

        @DisplayName("해당 요소가 Set Collection 에 존재하면 정상적으로 통과되어야 한다")
        @ParameterizedTest
        @ValueSource(ints = {1, 2, 3})
        void set_collection_contains_test(int param) {
            assertThat(numbers).contains(param);
        }

        @DisplayName("해당 요소가 Set Collection 에 존재하면 true, 아니라면 false 를 반환해야 한다")
        @ParameterizedTest
        @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
        void set_collection_contains_test_2(int input, boolean expected) {
            boolean actualValue = numbers.contains(input);
            assertEquals(expected, actualValue);
        }
    }
}
