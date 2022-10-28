import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class NumberTest {
    @Test
    public void 양수가_아닌경우_exception() {
        assertThatThrownBy(() -> new Number("-1"))
            .isInstanceOf(RuntimeException.class);
    }

    @Test
    public void 숫자가_아닌경우_exception() {
        assertThatThrownBy(() -> new Number("?"))
            .isInstanceOf(RuntimeException.class);
    }
}
