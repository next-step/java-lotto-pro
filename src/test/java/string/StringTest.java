package string;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringTest {

    @Test
    void split_contains() {
        // given
        String input = "1,2";

        // when
        String[] splitResult = input.split(",");

        // then
        assertThat(splitResult).contains("1");
        assertThat(splitResult).contains("2");
    }

    @Test
    void split_contains_exactly() {
        // given
        String input = "1";

        // when
        String[] splitResult = input.split(",");

        // then
        assertThat(splitResult).containsExactly("1");
    }

    @Test
    void substring() {
        // given
        String input = "(1,2)";

        // when
        String result = input.substring(1, 4);

        // then
        assertThat(result).isEqualTo("1,2");
    }
}
