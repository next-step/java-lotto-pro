package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    void split() {
        String[] result = "1,2".split(",");
        Assertions.assertThat(result).containsExactly("1", "2");

    }

    @Test
    void substring() {
        String result = "(1,2)".substring(1, 4);
        Assertions.assertThat(result).contains("1,2");

    }
}
