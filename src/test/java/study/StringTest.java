package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    void split() {
        final String[] result = "1,2".split(",");
        Assertions.assertThat(result).contains("1");
        Assertions.assertThat(result).contains("2");
        Assertions.assertThat(result).containsExactly("1", "2");
    }
}
