package study;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @ParameterizedTest
    @CsvSource({"0,a", "1,b", "2,c"})
    void charAt_1(int index, char expected) {
        String input = "abc";

        char result = input.charAt(index);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void charAt_2_exception() {
        String input = "abc";

        assertThatThrownBy(() -> input.charAt(3)).isInstanceOf(StringIndexOutOfBoundsException.class);
    }

}
