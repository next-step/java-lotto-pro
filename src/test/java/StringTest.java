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
}
