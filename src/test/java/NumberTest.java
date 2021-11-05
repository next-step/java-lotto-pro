import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumberTest {
    @Test
    void instantiate_negative() {
        assertThatThrownBy(() -> new Number("-1"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void equals() {
        assertThat(new Number("1")).isEqualTo(new Number("1"));
        assertThat(new Number("2")).isEqualTo(new Number("2"));
        assertThat(new Number("1")).isNotEqualTo(new Number("2"));
    }

    @Test
    void getValue() {
        Number number = new Number("1");
        assertThat(number.getValue()).isEqualTo(1);
    }
}
