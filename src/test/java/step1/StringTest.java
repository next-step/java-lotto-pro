package step1;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class StringTest {
    @Test
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1","2");
        assertThat(result).containsExactly("1","2");
    }

    @Test
    void substring() {
        String result = "(1,2)".substring(1,4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    void exception() {
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> "abc".charAt(3)
                ).withMessageContaining("String index out of range: 3");
    }
}
