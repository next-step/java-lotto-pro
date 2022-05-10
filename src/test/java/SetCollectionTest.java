import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

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
}
