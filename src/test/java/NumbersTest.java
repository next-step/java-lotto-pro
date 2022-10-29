import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class NumbersTest {
    @Test
    void 숫자_총합_계산() {
        Numbers numbers = new Numbers(Arrays.asList(1, 2, 3, 4, 5));
        assertThat(numbers.sum()).isEqualTo(15);
    }
}
