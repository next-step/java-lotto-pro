import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class NumbersTest {
    @Test
    void instantiate_negative() {
        assertThatThrownBy(() -> new Numbers("-1", "3", "4"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void sum_숫자하나() {
        Numbers numbers = new Numbers("1");
        assertThat(numbers.sum()).isEqualTo(1);
    }

    @Test
    void sum_숫자여러개() {
        Numbers numbers = new Numbers("1", "2");
        assertThat(numbers.sum()).isEqualTo(3);

        numbers = new Numbers("1", "2", "3");
        assertThat(numbers.sum()).isEqualTo(6);
    }
}
