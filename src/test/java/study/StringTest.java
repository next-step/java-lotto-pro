package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    @Test
    void 문자열_콤마로_split() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }
}
