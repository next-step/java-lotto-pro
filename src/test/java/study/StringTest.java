package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    private static final String SEPARATOR = ",";

    @Test
    void split_1() {
        String[] result = "1,2".split(SEPARATOR);

        assertThat(result).contains("1");
        assertThat(result).contains("2");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void split_2() {
        String[] result = "1".split(SEPARATOR);

        assertThat(result).contains("1");
        assertThat(result).containsExactly("1");
    }

    @Test
    void substring() {
        String input = "(1,2)";
        String expected = "1,2";

        String result = input.substring(1, input.length() - 1);

        assertThat(result).isEqualTo(expected);
    }

}
