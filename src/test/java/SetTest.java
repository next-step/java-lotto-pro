import java.util.HashSet;
import java.util.Set;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

}
