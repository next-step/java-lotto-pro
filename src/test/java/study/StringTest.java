package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringTest {
    @Test
    void split_multiple() {
        String given = "1,2";
        String[] when = given.split(",");
        // then
        assertThat(when).contains("1");
        assertThat(when).containsExactly("1", "2");
        assertEquals(when.length, 2);
    }

    @Test
    void split_single() {
        String given = "1";
        String[] when = given.split(",");
        // then
        assertThat(when).containsExactly("1");
        assertThat(when).doesNotContain("2");
        assertEquals(when.length, 1);
    }

    @Test
    void substring() {
        String given = "(1,2)";
        String when = given.substring(1, given.length()-1);
        // then
        assertThat(when).isEqualTo("1,2");
    }

    @Test
    void charAt_in_range() {
        String given = "abc";
        char when = given.charAt(1);
        // then
        assertThat(when).isEqualTo('b');
    }

    @Test
    void charAt_out_of_range() {
        String given = "abc";
        assertThatThrownBy(()-> {
            char when = given.charAt(given.length());
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
        .hasMessageContaining("out of range: " + given.length());
    }
}
