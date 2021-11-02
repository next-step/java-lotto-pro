package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    @Test
    void split() {
        // given
        final String text = "1,2";
        // when
        final String[] result = text.split(",");
        // then
        assertThat(result).contains("1");
        assertThat(result).contains("2");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void substring() {
        // given
        final String text = "(1,2)";
        // when
        final String result = text.substring(1, text.length() - 1);
        // then
        assertThat(result).isEqualTo("1,2");
    }


}
