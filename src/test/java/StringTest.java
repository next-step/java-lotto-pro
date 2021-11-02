import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    @Test
    void 숫자를_콤마로_나눈다() {
        assertThat("1,2".split(",")).containsExactly("1", "2");
    }

    @Test
    void 하나의_숫자를_콤마로_나눈다() {
        assertThat("1".split(",")).containsExactly("1");
    }

    @Test
    void 괄호를_제거한다() {
        final String text = "(1,2)";
        assertThat(text.substring(1, text.length() - 1)).isEqualTo("1,2");
    }
}
